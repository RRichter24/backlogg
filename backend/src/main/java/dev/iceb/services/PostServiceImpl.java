package dev.iceb.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

import dev.iceb.beans.Comment;
import dev.iceb.beans.Post;
import dev.iceb.data.PostDAO;
import dev.iceb.data.PostDAOFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	private PostDAO postDao;
	
	@Autowired
	public PostServiceImpl(PostDAO pDAO) {
		postDao = pDAO;
	}
	
	public Post addPost(Post p) {
		return postDao.add(p);
	}

	public Post getPostById(Integer id) {
		return postDao.getById(id);
	}

	public Set<Post> getPostsByUserId(Integer id) {
		Set<Post> userPosts = postDao.getByUserId(id);
		Set<Post> twoDayOldUserPosts = new HashSet<Post>();
		LocalDateTime comparisonDate = LocalDateTime.now(ZoneId.of("America/New_York"));
		
		for (Post post: userPosts) {
			LocalDateTime postTime = post.getPost_date();
			int comparisonYear = comparisonDate.getYear();
			int postYear = postTime.getYear();
			int comparisonDayOfYear = comparisonDate.getDayOfYear();
			int postDayOfYear = postTime.getDayOfYear();
			int comparisonHour = comparisonDate.getHour();
			int postHour = postTime.getHour();
			int comparisonMinutes = comparisonDate.getMinute();
			int postMinutes = postTime.getMinute();
			int comparisonSecond = comparisonDate.getSecond();
			int postSecond = postTime.getSecond();

			
			//the most common disqualification: 
			//the years are not adjacent years (1/1/2021, 12/30/2020) --> (1/2/2021, 12/31/2020)
			if (comparisonYear - postYear > 1) {
				//twoDayOldUserPosts.remove(post);
				continue;
			}
			else if (comparisonYear - postYear == 1){
				//of course, must take into account leap years (every 4 except every 100, but ignore every 100 if every 400)
				if (postYear % 4 == 0 && (postYear % 100 != 0 || postYear % 400 == 0)) {
					if (comparisonDayOfYear + 366 - postDayOfYear > 2) {
						//twoDayOldUserPosts.remove(post);
						continue;
					}
					else if (comparisonDayOfYear + 366 - postDayOfYear == 2) {
						if (comparisonHour > postHour 
								|| comparisonHour == postHour && comparisonMinutes > postMinutes 
								|| comparisonHour == postHour && comparisonMinutes == postMinutes && comparisonSecond > postSecond) {
							//twoDayOldUserPosts.remove(post);
							continue;
						}
					}
					else {
						twoDayOldUserPosts.add(post);
					}
				}
				else {
					if (comparisonDayOfYear + 365 - postDayOfYear > 2) {
						//twoDayOldUserPosts.remove(post);
						continue;
					}
					else if (comparisonDayOfYear + 365 - postDayOfYear == 2) {
						if (comparisonHour > postHour 
								|| comparisonHour == postHour && comparisonMinutes > postMinutes 
								|| comparisonHour == postHour && comparisonMinutes == postMinutes && comparisonSecond > postSecond) {
							//twoDayOldUserPosts.remove(post);
							continue;
						}
					}
					else {
						//nothing is supposed to happen here
						twoDayOldUserPosts.add(post);
					}
				}
				continue;
			}
			//the days are more than two days apart
			//the months are not neighboring months by subtraction, (march 31/april 1)
			else {
				if (comparisonDayOfYear - postDayOfYear > 2) {
					twoDayOldUserPosts.remove(post);
					continue;
				}
				else if (comparisonDayOfYear - postDayOfYear == 2) {
					if (comparisonHour > postHour 
							|| comparisonHour == postHour && comparisonMinutes > postMinutes 
							|| comparisonHour == postHour && comparisonMinutes == postMinutes && comparisonSecond > postSecond) {
						twoDayOldUserPosts.remove(post);
						continue;
					}
				}
				else {
					//nothing is supposed to happen here
					twoDayOldUserPosts.add(post);
				}
				continue;
			}
		}
		
		return twoDayOldUserPosts;
	}

	public Set<Post> getPostsByUsername(String u) {
		return postDao.getByUsername(u);
	}

	public Set<Post> getPosts() {
		return postDao.getAll();
	}

	public void updatePost(Post p) {
		postDao.update(p);
	}

	public void removePost(Post p) {
		postDao.delete(p);
	}

	@Override
	public Set<Comment> getCommentsByPostId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

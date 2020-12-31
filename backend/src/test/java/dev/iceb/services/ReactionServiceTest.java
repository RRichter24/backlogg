package dev.iceb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.iceb.beans.Reaction;
import dev.iceb.data.ReactionDAO;

@ExtendWith(MockitoExtension.class)
public class ReactionServiceTest {

	@Mock
	private ReactionDAO rDao;
	
	@InjectMocks
	private ReactionServiceImpl rServ;
	
	static Set<Reaction> reactionMock = new HashSet<>();
	static Integer sequenceMock = 1;
	
	@Test
	public void testAddReaction() {
		Reaction p = new Reaction();
		p.setId(1);
		reactionMock.add(p);
		
		Reaction p2 = new Reaction();
		p2.setId(sequenceMock +=1);
		
		when(rDao.add(p)).thenReturn(p2);
		assertNotEquals(p.getId().intValue(), rServ.addReaction(p).getId().intValue());
		verify(rDao).add(p);
	}
}

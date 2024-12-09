package com.shortener.application;

import com.shortener.domain.IdGenerator;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShortUrlCreatorTest {

	@InjectMocks
	private ShorUrlCreator shorUrlCreator;

	@Mock
	private UrlMappingRepository urlMappingRepository;

	@Mock
	private IdGenerator idGenerator;

	@Test
	void shouldCreate_returnHash() {
		String origin = "https://www.google.com";
		when(this.idGenerator.generate()).thenReturn("1234567");
		when(this.urlMappingRepository.save(any(UrlMapping.class))).thenReturn(Optional.of(new UrlMapping(origin, "1234567", LocalDateTime.now(), LocalDateTime.now().plusYears(1))));
		String hash = shorUrlCreator.create(origin);
		assert hash.length() == 7;
		verify(this.urlMappingRepository, times(1)).save(any(UrlMapping.class));
	}

}

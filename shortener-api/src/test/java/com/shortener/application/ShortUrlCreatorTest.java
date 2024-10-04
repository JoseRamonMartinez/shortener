package com.shortener.application;

import com.shortener.domain.IdGenerator;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class ShortUrlCreatorTest {

	@InjectMocks
	private ShorUrlCreator shorUrlCreator;

	@Mock
	private UrlMappingRepository urlMappingRepository;

	@Mock
	private IdGenerator idGenerator;

	@Test
	void shouldCreate_returnHash() {
		String originalUrl = "https://www.google.com";
		when(this.idGenerator.generate()).thenReturn("1234567");
		when(this.urlMappingRepository.save(any(UrlMapping.class))).thenReturn(Optional.of(new UrlMapping(originalUrl, "1234567", LocalDateTime.now(), LocalDateTime.now().plusYears(1))));
		String hash = shorUrlCreator.create(originalUrl);
		assert hash.length() == 7;
		verify(this.urlMappingRepository, times(1)).save(any(UrlMapping.class));
	}

}

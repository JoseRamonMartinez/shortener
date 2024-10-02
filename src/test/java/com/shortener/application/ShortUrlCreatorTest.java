package com.shortener.application;

import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class ShortUrlCreatorTest {

	@InjectMocks
	private ShorUrlCreator shorUrlCreator;

	@Mock
	private UrlMappingRepository urlMappingRepository;

	@Test
	void shouldCreate_returnHash() {
		String originalUrl = "https://www.google.com";
		String hash = shorUrlCreator.create(originalUrl);
		assert hash.length() == 7;
		verify(this.urlMappingRepository, times(1)).save(any(UrlMapping.class));
	}

}

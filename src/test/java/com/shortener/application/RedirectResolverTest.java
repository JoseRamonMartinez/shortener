package com.shortener.application;

import com.shortener.domain.Hash;
import com.shortener.domain.UrlMapping;
import com.shortener.domain.UrlMappingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@SpringBootTest
class RedirectResolverTest {

	@InjectMocks
	private RedirectResolver redirectResolver;

	@Mock
	private UrlMappingRepository urlMappingRepository;

	@Test
	void shouldRedirect_whenHash() {
		String hash = "Y8hF8Fh";
		String originalUrl = "https://www.google.com";
		UrlMapping urlMappingMock = new UrlMapping(originalUrl, hash, LocalDateTime.now(), LocalDateTime.now().plusYears(1));
		when(this.urlMappingRepository.findByHash(any(Hash.class))).thenReturn(urlMappingMock);
		String originalUrlResolved = redirectResolver.resolve(hash);
		assert originalUrlResolved.equals(originalUrl);
		verify(this.urlMappingRepository, times(1)).findByHash(new Hash(hash));
	}

}

package de.hsw.kennzeichen;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.hsw.kennzeichen.services.KennzeichenService;

@SpringBootTest
class KennzeichenApplicationTests {

	private KennzeichenService service;

	@Autowired
	public KennzeichenApplicationTests(KennzeichenService service){
		this.service = service;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void kennzeichenFrei() {
		assertFalse(service.isVergeben("A-BC-999"));
	}

	@Test
	void kennzeichenBelegt() {
		assertTrue(service.isVergeben("B-ER-1234"));
	}

	@Test
	void kennzeichenReserviert() {
		assertTrue(service.isReserviert("HX-HX-1"));
	}

	@Test
	void kennzeichenNichtReserviert() {
		assertFalse(service.isReserviert("HX-HX-2"));
	}

	@Test
	void kennzeichenReservieren() {
		String token = service.reservieren("HX-HX-3");
		assertNotNull(token);
	}

	@Test
	void kennzeichenReservierenBereitsReserviert() {
		assertThrows(IllegalArgumentException.class, () -> {
            service.reservieren("HX-HX-1");
        });
	}

	@Test
	void kennzeichenReservierenBereitsVergeben() {
		assertThrows(IllegalArgumentException.class, () -> {
            service.reservieren("HM-HM-12");
        });
	}

	@Test
	void kennzeichenEinloesen() {
        service.einloesen("RS-VT-1", "TOKEN");
	}

	@Test
	void kennzeichenEinloesenNichtReserviert() {
		assertThrows(IllegalArgumentException.class, () -> {
            service.einloesen("RS-VT-2", "TOKEN");
        });
	}

	@Test
	void kennzeichenEinloesenVergeben() {
		assertThrows(IllegalArgumentException.class, () -> {
            service.einloesen("RS-VT-3", "TOKEN");
        });
	}

	@Test
	void kennzeichenEinloesenFalscherToken() {
		assertThrows(IllegalArgumentException.class, () -> {
            service.einloesen("RS-VT-4", "TOKEN FALSCH");
        });
	}
}

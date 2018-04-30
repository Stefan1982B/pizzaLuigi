package be.vdab.pizzaluigi.restclients;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import be.vdab.pizzaluigi.exceptions.KoersClientException;

@Component
@Qualifier("Fixer")
class FixerKoersClient implements KoersClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(FixerKoersClient.class);
	private URL url;

	FixerKoersClient() {
		try {
			url = new URL("https://api.fixer.io/latest?symbols=USD");
		} catch (MalformedURLException ex) {
			String fout = "Fixer URL is verkeerd:" + url;
			LOGGER.error(fout, ex);
			throw new KoersClientException(fout);
		}
	}

	@Override
	public BigDecimal getDollarKoers() {
		try (Scanner scanner = new Scanner(url.openStream())) {
			String lijn = scanner.nextLine();
			int beginPositieKoers = lijn.indexOf("USD") + 5;
			int accoladePositie = lijn.indexOf("}", beginPositieKoers);
			LOGGER.info("koers gelezen via Fixer");
			return new BigDecimal(lijn.substring(beginPositieKoers, accoladePositie));
		} catch (IOException | NumberFormatException ex) {
			String fout = "kan koers niet lezen via Fixer";
			LOGGER.error(fout, ex);
			throw new KoersClientException(fout);
		}
	}
}

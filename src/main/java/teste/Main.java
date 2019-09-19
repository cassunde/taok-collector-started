package teste;

import java.time.LocalDate;

import br.com.taok.collector.api.Collector;
import br.com.taok.collector.api.model.Provider;
import br.com.taok.collector.api.model.standard.Search;
import br.com.taok.collector.ce.fortaleza.CeFortalezaCollector;

public class Main {

	public static void main(String[] args) {
		
		Provider cagece = new Provider() {
			
			@Override
			public String getDescription() {
				return "Enel";
			}
			
			@Override
			public String getCNPJ() {
				return "007.040.108/0001-57";
			}
		};

		LocalDate startDate = LocalDate.of(2019, 7, 1);
		LocalDate endDate = LocalDate.of(2019, 7, 31);
		
		Search search = new Search(startDate, endDate, cagece, null);
		
		Collector collector =  new CeFortalezaCollector();
		collector.collectNow(search).launchs();

		System.out.println(collector.amount());
		
		collector.providers().stream().forEach( p -> System.out.println(p.getDescription()) );

	}
}

package br.ufms.facom.sensitivitygenerator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 * Hello world!
 *
 */
public class App 
{
	private String input = "";
	private String output = "";
	private int numberOfFiles;
	List<String[]> data = new ArrayList<String[]>();
	List<String[]> pairs = new ArrayList<String[]>();
	
	public App(String input, String output, int numberOfFiles){
		this.input = input;
		this.output = output;
		this.numberOfFiles = numberOfFiles;
	}
	
	void loadData() {
		File csvFile = new File(this.input);
		Iterable<CSVRecord> records;
		try {
			records = CSVFormat.RFC4180.withDelimiter(';').parse(new FileReader(csvFile));

			for (CSVRecord csvRecord : records) {
				String[] record = new String[3];
				record[0] = csvRecord.get(0);
				record[1] = csvRecord.get(1);
				this.data.add(record);
			}
		} catch (IOException e) {
			System.err.println("Conteudo de entrada mal formatado. Não foi possível realizar o Parsing.");
			e.printStackTrace();
		}
	}

	void calculateSimilarity(){
		
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

package com.sherman.Covid19Tracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.sherman.Covid19Tracker.models.Provinces;




@Service
public class CovidData {
private String Confirmed="https://raw.githubusercontent.com/dsfsi/covid19za/master/data/covid19za_provincial_cumulative_timeline_confirmed.csv";
private String Recover="https://raw.githubusercontent.com/dsfsi/covid19za/master/data/covid19za_provincial_cumulative_timeline_recoveries.csv";
private String Death="https://raw.githubusercontent.com/dsfsi/covid19za/master/data/covid19za_provincial_cumulative_timeline_deaths.csv";
private Provinces recover;
private Provinces confirmed;
private Provinces death;
private Provinces active;

@PostConstruct
public void getdata() throws IOException, InterruptedException {
	confirmed=csvdata(Confirmed);

	recover=csvdata(Recover);
	
	death=csvdata(Death);
	
	
}
private  Provinces csvdata(String url) throws IOException, InterruptedException {
	HttpClient client=HttpClient.newHttpClient();
	HttpRequest request=HttpRequest.newBuilder().uri(URI.create(url)).build();
	HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
	
	StringReader data=new StringReader(response.body());

	Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(data);

	Provinces province =new Provinces();
	
	for (CSVRecord record : records) {
	 province.setGP(record.get("GP"));
	 province.setNW(record.get("NW"));
	 province.setLP(record.get("LP"));
	 province.setMP(record.get("MP"));
	 province.setWC(record.get("WC"));
	 province.setNC(record.get("NC"));
	 province.setFS(record.get("FS"));
	 province.setKZN(record.get("KZN"));
	 province.setEC(record.get("EC"));
	 province.setTotal(record.get("total"));
	 province.setDate(record.get("date"));
	 
	 
	}
	  

return province;
	
}
public Provinces getProvinceC() {
	return confirmed;
	}
public Provinces getProvinceR() {
	return recover;
	}
public Provinces getProvinceD() {
	return death;
	}
public int active(String C,String D,String R) {
	String c=C;
	String d=D;
	String r=R;	
	int cC=Integer.parseInt(c);
	int dD=Integer.parseInt(d);
	int rR=Integer.parseInt(r);
	int active=cC-(rR+dD);
	return active;
	
}
}



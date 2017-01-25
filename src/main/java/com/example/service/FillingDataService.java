package com.example.service;

import com.example.domain.Country;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FillingDataService {

    private Map<String,List<Country>> countryList = new HashMap<>();

    public FillingDataService() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<Country>> getCountryList(){
        return countryList;

    }

    public void init() throws IOException {
        Document document = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_country_calling_codes").get();
        Element table = document.getElementsByTag("table").get(1);
        Element tbody = table.select("tbody").first();
        Elements rows = tbody.select("tr");

        String countryName;
        for (int i = 1; i < rows.size(); i++) {
            Element firstTd = rows.get(i).child(0);
            countryName = firstTd.text();

            Element secondTd = rows.get(i).child(1);
            Elements links = secondTd.getElementsByTag("a");
            for(Element link : links){
                if(link.text().contains("+")){
                    String lnk = link.text();
                    String[] arr = lnk.split(",");
                    for(String s : arr){
                        String phone = s.replaceAll("[^0-9/+?]", "");
                        Country country = new Country();
                        country.setName(countryName);
                        if(!countryList.containsKey(phone)) {
                            List<Country> countries = new ArrayList<>();
                            countries.add(country);
                            countryList.put(phone, countries);
                        }else {
                            List<Country> list = countryList.get(phone);
                            list.add(country);
                            countryList.put(phone, list);
                        }

                    }
                }
            }
        }
        countryList.forEach((k, v) -> System.out.println(k + " " + v.toString()));
        System.out.println("list size = " + countryList.size());
    }

}

package ru.mirea;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String,String> mp =new HashMap<String, String>();
        mp.put("Bogor","Vlad");//Фамилия имя
        mp.put("Trug","Aq");
        mp.put("Mer","Bw");
        mp.put("Mus","Tr");
        mp.put("SD","Tr");
        mp.put("RTE","fsdaaa");
        mp.put("FSDF","Vlad");
        mp.put("BSDF","DSFsdf");
        mp.put("ASDASD","nNNN");
        mp.put("NFDNFDN","fsdffsdfds");

        System.out.println(mp);

        Map<String,Integer> mpFrequncy=new HashMap<String, Integer>();//Второй мап, имя - число повторов
        LinkedList<String> keys=new LinkedList<String>(mp.values()); // имена

        for (int i = 0; i < keys.size() ; i++) {
            if(mpFrequncy.get(keys.get(i))==null){
                mpFrequncy.put(keys.get(i),1); //если в первый раз
            }
            else{
                mpFrequncy.put(keys.get(i),mpFrequncy.get(keys.get(i))+1);//повторы

            }
        }

        System.out.println(mpFrequncy);
        keys=new LinkedList<String>(mpFrequncy.keySet());//имена
        for (int i = 0; i < keys.size() ; i++) {
            if(mpFrequncy.get(keys.get(i))>1) { //если больше одного повтора, бежим по мапу
                HashMap<String, String> copy = new HashMap<String, String>(mp); //копия, иначе исключение  java.util.ConcurrentModificationException
                for (Map.Entry<String, String> pair : copy.entrySet()) { //ключ значение
                    if (pair.getValue().equals(keys.get(i)))  //если у фамилии значение имени совпадает с keys.get(i)
                        mp.remove(pair.getKey());
                }


            }
        }
        System.out.println(mp);//первый пункт закончен

        System.out.println();



        Map<String,ArrayList<String>> map = new HashMap(); //в чём будет конечный ответ

        Set<City> cities=new HashSet<City>(){}; //изначальный ввод данных
        cities.add(new City("Russia","Moscow"));
        cities.add(new City("Russia","Krasnodar"));
        cities.add(new City("USA","New York"));
        cities.add(new City("Belarus","Minsk"));
        cities.add(new City("Belarus","Brest"));
        System.out.println(cities);

       Set<String> namesOfCountries= new HashSet<>();//страны
        for (City t: cities
             ) {
            namesOfCountries.add(t.getCountry()); //множество названий стран
        }
            for (String countryName:namesOfCountries) { // пробегаемся по множеству
                ArrayList<String>citiesString= new ArrayList<>();
                    for (City t:cities) { //пробегаемся по всем городам, в случае с совпадением названия города и страны - true
                      if(t.getCountry()==countryName) citiesString.add(t.getGround());
                }
                map.put(countryName,citiesString); //добавляем страну с её городами
        }
        System.out.println(map);

    }
}

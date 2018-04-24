package com.kcci.emmi.donasmainview;

import java.util.ArrayList;
import java.util.HashMap;

public class RegionListViewItem {
    HashMap<Integer, ArrayList<String>> map;
    ArrayList<String> dataList;

    public RegionListViewItem(){
        map = new HashMap<>();
        dataList = new ArrayList<>();
        dataList.add("강남/역삼/삼성/논현");
        dataList.add("서초/신사/방배");
        dataList.add("잠실/신천");
        dataList.add("천호/길동/둔촌");
        dataList.add("구로/영등포/여의도/목동");
        dataList.add("신림/서울대/사당/금천/동작");
        dataList.add("강서/화곡/까치산/양천");
        dataList.add("신촌/홍대/합정");
        dataList.add("연신내/불광/응암");
        dataList.add("종로/대학로");
        dataList.add("성신여대/성북/월곡");
        dataList.add("이태원/용산/서울역/명동/회현");
        dataList.add("동대문/충무로/신당/약수/금호");
        dataList.add("건대/군자/구의");
        dataList.add("동묘/신설동/청량리/회기");
        dataList.add("장안동/답십리");
        dataList.add("수유/미아");
        dataList.add("왕십리/성수");
        dataList.add("상봉/중랑/면목");
        dataList.add("태릉/노원/도봉/창동");
        map.put(0, dataList);

        dataList = new ArrayList<>();
        dataList.add("수원/인계/권서/영통");
        dataList.add("수원역/구운/장안/세류");
        dataList.add("안양/평촌/인덕원/과천");
        dataList.add("성남/분당/위례");
        dataList.add("용인");
        dataList.add("동탄/오산/병점");
        dataList.add("하남/광주/여주/이천");
        dataList.add("부천");
        dataList.add("시흥/광명");
        dataList.add("평택/송탄/화성/안성");
        dataList.add("안산");
        dataList.add("군포/의왕/금정/산본");
        dataList.add("일산/고양");
        dataList.add("김포/파주");
        dataList.add("의정부");
        dataList.add("구리/남양주");
        dataList.add("가평/청평");
        dataList.add("양평");
        dataList.add("포천/양주/동두천/연천");
        dataList.add("제부도/대부도");
        map.put(1, dataList);

        dataList = new ArrayList<>();
        dataList.add("부평/동암");
        dataList.add("서구/계양/동구");
        dataList.add("구월");
        dataList.add("주안");
        dataList.add("송도/연수");
        dataList.add("중구/인천공항/월미도/항동/강화/옹진");
        dataList.add("간석/소래포구/만수");
        dataList.add("용현/숭의/도화");
        map.put(2, dataList);

        dataList = new ArrayList<>();
        dataList.add("춘천/강촌");
        dataList.add("강릉/경포대/정동진/주문진");
        dataList.add("원주");
        dataList.add("영월/정선");
        dataList.add("속초/양양/고성");
        dataList.add("동해/삼척/태백");
        dataList.add("평창");
        dataList.add("송천/횡성");
        dataList.add("화천/철원/인제/양구");
        map.put(3, dataList);

        dataList = new ArrayList<>();
        dataList.add("제주시");
        dataList.add("서귀포시");
        dataList.add("하귀/애월/한림/협재");
        dataList.add("조천/함덕/김녕/성산");
        map.put(4, dataList);

        dataList = new ArrayList<>();
        dataList.add("유성구");
        dataList.add("중구(은행/대흥/선화)");
        dataList.add("동구(용전/복합터미널)");
        dataList.add("서구(둔산/용문)");
        dataList.add("대덕구(중리/신탄진)");
        map.put(5, dataList);

        dataList = new ArrayList<>();
        dataList.add("청주 흥덕구/서원구(터미널/충북대)");
        dataList.add("청주 상당구/청원구(북문로/청주대/용암/오창)");
        dataList.add("충주/제천/진천/음성/단양");
        dataList.add("보은/옥천/괴산/증평/영동");
        map.put(6, dataList);

        dataList = new ArrayList<>();
        dataList.add("천안");
        dataList.add("세종");
        dataList.add("계룡/공주/금산/논산/청양");
        dataList.add("아산/예산/홍성");
        dataList.add("태안/안면도/서산/당진");
        dataList.add("보령/대천/서천/부여");
        map.put(7, dataList);

        dataList = new ArrayList<>();
        dataList.add("해운대/센텀시티/재송동");
        dataList.add("송정/기장/정관");
        dataList.add("광안리/경성대/대연/용호동/문현");
        dataList.add("연산/토곡");
        dataList.add("서면/양정/초읍/부산시민공원");
        dataList.add("남포동/부산역/태종대/송도/범일동");
        dataList.add("동래/사직/온천장/부산대/구서");
        dataList.add("사상/엄궁/학장");
        dataList.add("덕천/하단/구포/괴정/만덕/화명동/명지/녹산공단/김해공항");
        map.put(8, dataList);

        dataList = new ArrayList<>();
        dataList.add("동구/북구/울주군(진하/일산/KTX역/등억리)");
        dataList.add("남구/중구(삼산/성남/무거/시청)");
        map.put(9, dataList);

        dataList = new ArrayList<>();
        dataList.add("창원");
        dataList.add("마산/진해");
        dataList.add("김해/장유");
        dataList.add("양산/밀양");
        dataList.add("진주/사천/남해");
        dataList.add("거제/통영/고성");
        dataList.add("거창/하동/함안/창녕/기타");
        map.put(10, dataList);

        dataList = new ArrayList<>();
        dataList.add("동성로/서문시장/대구역/경북대/엑스코/칠곡지구/태전동");
        dataList.add("동대구역/신천동/혁신도시/동촌유원지/대구공항/팔공산");
        dataList.add("수성못/황금동/들안길/두산동/지산동");
        dataList.add("북부정류장/평리동/비산동/대명동/봉덕동/안지랑");
        dataList.add("두류공원/본리동/죽전동/성서/서부정류장/달성군");
        map.put(11, dataList);

        dataList = new ArrayList<>();
        dataList.add("포항");
        dataList.add("경주");
        dataList.add("구미");
        dataList.add("경산/영천/청도");
        dataList.add("김천/칠곡/성주");
        dataList.add("안동");
        dataList.add("문경/상주/영주/예천/군위/의성/봉화");
        dataList.add("울진/영덕/청송");
        dataList.add("울릉도");
        map.put(12, dataList);

        dataList = new ArrayList<>();
        dataList.add("상무지구/금호지구/유스퀘어/서구");
        dataList.add("첨단지구/하남지구/송정역/광산구");
        dataList.add("충장로/대인시장/국립아시아문화전당/동구/남구");
        dataList.add("광주역/기아챔피언스필드/전대사거리/북구");
        map.put(13, dataList);

        dataList = new ArrayList<>();
        dataList.add("여수");
        dataList.add("순천/광양");
        dataList.add("목포/무안/나주/영암/함평/영광");
        dataList.add("해남/완도/진도/고흥/장흥/강진/신안/담양/화순/보성/곡성/구례/장성");
        map.put(14, dataList);

        dataList = new ArrayList<>();
        dataList.add("전주/완주");
        dataList.add("군산");
        dataList.add("익산");
        dataList.add("남원/정읍/부안/김제/임실/장수/무주/고창/순창/진안");
        map.put(15, dataList);
    }

    public HashMap<Integer, ArrayList<String>> getMap() {
        return map;
    }

    public ArrayList<String> getDataList() {
        return dataList;
    }

}

# 전국 포장마차(타코야키) 검색 어플리케이션(Project PJMC)
이 프로젝트는 구글 오픈 맵을 활용해 sns 유저들이 제공한 "대동타코야끼여지도"의 데이터를 활용하여 안드로이드 앱을 개발합니다. 

## 시작하기
### 프로그램 사용하기
> 1. Google Maps API에서 google_maps_key를 발급받습니다.
> 2. app/src/main/res/values/google_maps_api.xml의 `<string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">[발급받은 google_maps_key]</string>`를 수정합니다.
> 3. 프로젝트를 빌드합니다.
> 4. Android Emulator를 실행하여 앱을 Run합니다.

## 개발환경
- Java 설치 버전: JDK 1.8.0_161 
- Android: 
  - 'com.android.support:support-v4:26.1.0' 
  - 'com.google.maps.android:android-maps-utils:0.4+'
  - 'com.google.android.gms:play-services:12.0.1'
  
## 라이선스
This project is licensed under the MIT License

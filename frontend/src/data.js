import salad_img from './image_folder/salad_img.jpeg'
import salad from './image_folder/salad.jpeg' 
import rice from './image_folder/rice.jpeg' 
import bakery from './image_folder/bakery.jpeg' 

import bakery1 from './image_folder/f_bakery/고단백무설탕산소빵10개세트_29500.jpeg' 
import bakery2 from './image_folder/f_bakery/몬드베이커리_몬드_가족세트_63100.jpeg' 
import bakery3 from './image_folder/f_bakery/무설탕크럼블7종_49900.jpeg' 
import bakery4 from './image_folder/f_bakery/무화당무설탕생크림롤3개_24000.png' 
import bakery5 from './image_folder/f_bakery/무화당무설탕초코머핀3개_16500.jpeg' 
import bakery6 from './image_folder/f_bakery/무화당무설탕카스테라5개_22500.jpeg' 
import bakery7 from './image_folder/f_bakery/무화당저당카스테라3종(쑥,단호박,흑임자)_22500.jpeg' 
import bakery8 from './image_folder/f_bakery/무화당저당크림카스테라5종_12500.jpeg' 

import salad1 from './image_folder/f_salad/갈릭페퍼로스트닭다리살샐러드_11000.jpeg' 
import salad2 from './image_folder/f_salad/닭가슴살볼숯불갈비맛샐러드_9000.jpeg' 
import salad3 from './image_folder/f_salad/리코타치즈샐러드_5800.jpeg' 
import salad4 from './image_folder/f_salad/모짜렐라루꼴라샐러드_8000.jpeg' 
import salad5 from './image_folder/f_salad/베스트샐러드6종_49600.jpeg' 
import salad6 from './image_folder/f_salad/불고기샐러드_9800.jpeg' 
import salad7 from './image_folder/f_salad/스파이시쉬림프샐러드_5800.jpeg' 
import salad8 from './image_folder/f_salad/지라시포케샐러드_5800.jpeg' 
import salad9 from './image_folder/f_salad/참나물베지미트파스타샐러드_5800.jpeg' 
import salad10 from './image_folder/f_salad/치킨스테이크샐러드_7500.jpeg' 
import salad11 from './image_folder/f_salad/크랜베리치킨샐러드_4900.jpeg' 
import salad12 from './image_folder/f_salad/풍기리소토샐러드_5800.jpeg' 

import rice1 from './image_folder/f_rice/계란새우볶음밥_고구마닭가슴살스테이크_6100.jpeg' 
import rice2 from './image_folder/f_rice/곤드레나물밥_미니떡갈비_6300.jpeg' 
import rice3 from './image_folder/f_rice/나시고랭_닭가슴살소세지_6100.jpeg' 
import rice4 from './image_folder/f_rice/다섯가지나물밥_불고기오믈렛_6300.jpeg' 
import rice5 from './image_folder/f_rice/빠에야볶음밥_핫스테이크_6200.jpeg' 
import rice6 from './image_folder/f_rice/시래기보리밥_불고기오믈렛_5900.jpeg' 
import rice7 from './image_folder/f_rice/퀴노아고구마밥_갈릭소시지_5900.jpeg' 
import rice8 from './image_folder/f_rice/탄두리닭가슴살현미밥_미트볼스크램블_7000.jpeg' 


export const sliderItems = [
    {
      id: 1,
      img: salad_img,
      title: "New Year's Sale!",
      desc: "Life is busy and we know it. We have variety options. Don't comprise on your food!",
      bg: "f5fafd",
    },
    {
      id: 2,
      img: salad_img,
      title: "New Year's Sale!",
      desc: "Life is busy and we know it. We have variety options. Don't comprise on your food!",
      bg: "fcf1ed",
    },
    {
      id: 3,
      img: salad_img,
      title: "New Year's Sale!",
      desc: "Life is busy and we know it. We have variety options. Don't comprise on your food!",
      bg: "fbf0f4",
    },
  ];

export const categories = [
    {
      id: 1,
      img: salad,
      title: 'Salad',
    }, 
    {
      id: 2,
      img: rice,
      title: 'Rice',
    }, 
    {
      id: 3,
      img: bakery,
      title: 'Bakery',
    }, 
]

export const items = [
  {
    id: 1,
    img: bakery1,
    name: '고단백무설탕산소빵 10개세트',
    price: 29500,
    category_id: 3,
  },
  {
    id: 2,
    img: bakery2,
    name: '몬드베이커리몬드 가족세트',
    category_id: 3,
    price: 63100,
  },
  {
    id: 3,
    img: bakery3,
    name: '무설탕크럼블 7종',
    price: 49900,
    category_id: 3,
  },
  {
    id: 4,
    img: bakery4,
    name: '무화당무설탕생크림롤 3개',
    price: 24000,
    category_id: 3,
  },
  {
    id: 5,
    img: bakery5,
    name: '무화당무설탕초코머핀 3개',
    price: 16500,
    category_id: 3,
  },
  {
    id: 6,
    img: bakery6,
    name: '무화당무설탕카스테라 5개',
    price: 22500,
    category_id: 3,
  },
  {
    id: 7,
    img: bakery7,
    name: '무화당저당카스테라 3종(쑥,단호박,흑임자)',
    price: 22500,
    category_id: 3,
  },
  {
    id: 8,
    img: bakery8,
    name: '무화당저당크림카스테라 5종',
    price: 12500,
    category_id: 3,
  },
  

  {
    id: 9,
    img: salad1,
    name: '갈릭페퍼로스트닭다리살샐러드',
    price: 11000,
    category_id: 1,
  },
  {
    id: 10,
    img: salad2,
    name: '닭가슴살볼숯불갈비맛샐러드',
    price: 9000,
    category_id: 1,
  },
  {
    id: 11,
    img: salad3,
    name: '리코타치즈샐러드',
    price: 5800,
    category_id: 1,
  },
  {
    id: 12,
    img: salad4,
    name: '모짜렐라루꼴라샐러드',
    price: 8000,
    category_id: 1,
  },
  {
    id: 13,
    img: salad5,
    name: '베스트샐러드 6종',
    price: 49600,
    category_id: 1,
  },
  {
    id: 14,
    img: salad6,
    name: '불고기샐러드',
    price: 9800,
    category_id: 1,
  },
  {
    id: 15,
    img: salad7,
    name: '스파이시쉬림프샐러드',
    price: 5800,
    category_id: 1,
  },
  {
    id: 16,
    img: salad8,
    name: '지라시포케샐러드',
    price: 5800,
    category_id: 1,
  },
  {
    id: 17,
    img: salad9,
    name: '참나물베지미트파스타샐러드',
    price: 5800,
    category_id: 1,
  },
  {
    id: 18,
    img: salad10,
    name: '치킨스테이크샐러드',
    price: 7500,
    category_id: 1,
  },
  {
    id: 19,
    img: salad11,
    name: '크랜베리치킨샐러드',
    price: 4900,
    category_id: 1,
  },
  {
    id: 20,
    img: salad12,
    name: '풍기리소토샐러드',
    price: 5800,
    category_id: 1,
  },
  {
    id: 21,
    img: rice1,
    name: '계란새우볶음밥 & 고구마닭가슴살스테이크',
    price: 6100,
    category_id: 2,
  },
  {
    id: 22,
    img: rice2,
    name: '곤드레나물밥 & 미니떡갈비',
    price: 6300,
    category_id: 2,
  },
  {
    id: 23,
    img: rice3,
    name: '나시고랭 & 닭가슴살소세지',
    price: 6100,
    category_id: 2,
  },
  {
    id: 24,
    img: rice4,
    name: '다섯가지나물밥 & 불고기오믈렛',
    price: 6300,
    category_id: 2,
  },
  {
    id: 25,
    img: rice5,
    name: '빠에야볶음밥_핫스테이크',
    price: 6200,
    category_id: 2,
  },
  {
    id: 26,
    img: rice6,
    name: '시래기보리밥 & 불고기오믈렛',
    price: 5900,
    category_id: 2,
  },
  {
    id: 27,
    img: rice7,
    name: '퀴노아고구마밥 & 갈릭소시지',
    price: 5900,
    category_id: 2,
  },
  {
    id: 28,
    img: rice8,
    name: '탄두리닭가슴살현미밥 & 미트볼스크램블',
    price: 7000,
    category_id: 2,
  },
]
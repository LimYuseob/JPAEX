package com.fullstack.db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fullstack.db.entity.Memo;
import com.fullstack.db.repository.MemoRepository;

@SpringBootTest
class JpaexApplicationTests {

   /*
    * 실행시에 객체를 자동 주입 시켜주는 대표력 API 인 AutoWired 입니다. 이 어노테이션을 사용하면 프레임워크가 자동으로 해당
    * 인스턴스를 생성해서 주입(Injection) 해줍니다. 이런건 IOC 합니다.(제어역전컨트롤러)
    */

   @Autowired
   MemoRepository memorepository;

//   @Test
//   void contextLoads() {
//         IntStream.rangeClosed(1, 100).forEach(i -> {
//            Memo memo = Memo.builder().memoTxt("이건 JPA 엔티티가 넣은 데이터 " + i).build();
//            memorepository.save(memo);
//         });
//
//
//   }
//   
   
//   @Test
//   void testSelect() {
//      Long mno = 100L;
//      
//      Optional<Memo> result = memorepository.findById(mno);
//      System.out.println("===========================");
//      
//      if(result.isPresent()) {
//         Memo memo = result.get();
//         System.out.println(memo);
//      }
//   }
//   
   /*
    * getOne(조회PK 값)..-> 위의 findById와 유사한데, 틀린점은
    * Transaction 어노테이션이 반드시 들어가야 합니다.
    * 나머진 위와 같습니다.
    */
   
//   @Transactional
//   @Test
//   void testSelect2() {
//      Long mon = 55L;
//      
//      Memo memo = memorepository.getOne(mon);
//      
//      System.out.println(mon);
//   }
   
   /*
    * DB 삭제 : Repository 의 deleteSomething()...을 호출해서 지우면 됩니다.
    * 만약 특정 Row 를 삭제 하려고 할때 해당 로우넘이 없으면 예외를 발생시키니,
    * 그 점은 확인 하시면 됩니다.ERADExcption(축약한 예외 이름입니다.)
    */
   
//   @Test
//   public void delete() {
//      Long mno = 100L;
//            //memorepository.deleteById(mno); //<-- 지정된 값만 삭제
//            //memorepository.deleteAll(); //<-- 전체 삭제
//            
//   }
   
//   @Test
//   public void updateTest() {
//      //수정할 Entity 의 내용을 변경해 볼게요..
//      Memo memo = Memo.builder()
//                  .mno(401L)
//                  .memoTxt("이건 수정된 내용입니다.")
//                  .build();
//      System.out.println(memorepository.save(memo));
//   }
   
   /*
    * Pageable 인터페이스 : 페이징관리를 하는 중심 인터페이스 입니다.
    * 
    * 위 인터페이스 PageRequest 객체의 of 메서드를 이용해서 얻어낼수 있습니다.
    * 이 때 얻어낼 목록이나, 정렬, 등을 지정해서 사용할 수 있습니다.
    */
   
   //페이징을 위한 테이트 메서드 정의
//   @Test
//   public void testPaging1() {
//      
//     Pageable pageable = PageRequest.of(0, 10);
//     Page<Memo> result = memorepository.findAll(pageable);
//     System.out.println(result);
//   
////     System.out.println("================================");
////     System.out.println(result.getNumber());
////     System.out.println(result.getSize());
////     System.out.println(result.getTotalElements());
////     System.out.println(result.getTotalPages());
////     System.out.println(result.getContent());
////     System.out.println(result.hasNext());
////     System.out.println(result.hasPrevious());
////     System.out.println(result.isEmpty());
////     System.out.println(result.isFirst());
//  
//     //Sort객체를 얻어낼때 정렬될 키의 값을 주고, 정렬메서드를 통해
//     //정렬된 Sort 객체를 얻어낼수 있습니다.
//     Sort s1 = Sort.by("mno").ascending();
//     Sort s2 = Sort.by("memoTxt").descending();
//     Sort s3 = s1.and(s2);
//   
//     pageable= PageRequest.of(0, 10, s3);
//     result = memorepository.findAll(pageable);
//     
//     //foreach 구문을 이용해서 위 result 의 값들을 출력해보세요
//     result.get().forEach(r ->{
//        System.out.println("-->" + r);
//     });
//   }
     
//     memorepository.findAll();
   
     @Test
     public void testQueryMethod() {
//      List<Memo> list3 = memorepository.findByMnoBetweenOrderByMnoDesc(101L, 150L);
//      for(Memo memo : list3) {
//         System.out.println(memo);
//      }
        Pageable pageable = PageRequest.of(0, 10,Sort.by("mno").descending());
        Page<Memo> page = memorepository.findByMnoBetween(101L, 150L, pageable);
   }
}
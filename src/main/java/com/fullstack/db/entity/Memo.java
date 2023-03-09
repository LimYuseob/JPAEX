package com.fullstack.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//이 클래스는 엔티티 객체로 활용할 예정
//엔티티로 활용되기 위해서는 어노테이션 이용해 엔티티 선언해줘야 한다.
//대표적으로 entity, table(value="생성될 테이블 명")정도.
//이 선언문은 클래스에 선언을 해야 엔티티로 적용된다.

@Entity
@Table(name = "tbl_memo")//테이블 메모라는 테이블에 매핑시킨다.
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Memo {
	//엔티티 클래스를 매핑된 테이블의 컬럼에 사용될 필드를 선언한다.
	//보통은 PK를 갖도록 정이되어져서 PK 컬럼을 ID로 선언하고 PK전략(strategy) 즉, PK값을 누가 새상성할 지를 속성으로 명명한다.
	
	//보통 스프링에서는 P type의 데이터를 사용하지 않는다. 즉 모든 데이터는 객체 형태여야 한다.
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long mno;
	
	@Column(length = 200, nullable = false)
	private String memoTxt;
	
	
}

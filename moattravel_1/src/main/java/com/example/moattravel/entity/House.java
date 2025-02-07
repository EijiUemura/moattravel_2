package com.example.moattravel.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
//エンティティの宣言
@Entity
//参照DBの名前
@Table(name = "houses")
//ゲッターセッターの自動生成
@Data

public class House {
//主キーの指定と採番と
	//主キーを指定
	@Id
	//主キーの自動採番
	@GeneratedValue
	//主キーの取得(列）
	@Column(name = "id")
	//主キーの変数
	private Integer id;
	
	//カラムの名前やルールを設定
	@Column(name = "name")
	private String name;
	
	//カラムの名前やルールを設定
	@Column(name = "image_name")
	private String imageName;
	
	//カラムの名前やルールを設定
	@Column(name = "description")
	private String description;
	
	//カラムの名前やルールを設定
	@Column(name = "price")
	private Integer price;
	
	//カラムの名前やルールを設定
	@Column(name = "capacity")
	private Integer capacity;
	
	//カラムの名前やルールを設定
	@Column(name = "postal_code")
	private String postalCode;
	
	//カラムの名前やルールを設定
	@Column(name = "address")
	private String address;
	
	//カラムの名前やルールを設定
	@Column(name = "phone_number")
	private String phoneNumber;
	
	//カラムの名前やルールを設定
	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;
	
	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updateAt;

}

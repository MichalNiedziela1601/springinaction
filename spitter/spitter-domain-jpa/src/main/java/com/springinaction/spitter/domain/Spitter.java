package com.springinaction.spitter.domain;

import static java.util.Arrays.*;
import static javax.persistence.GenerationType.*;
import static org.apache.commons.lang.builder.EqualsBuilder.*;
import static org.apache.commons.lang.builder.HashCodeBuilder.*;
import static org.apache.commons.lang.builder.ToStringBuilder.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="spitter")
@XmlRootElement
public class Spitter implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;

  //<start id="java_SpitterValidated" /> 
  @Size(min=3, max=20, message=
      "Nazwa u�ytkownika musi si� sk�ada� z 3 do 20 znak�w.") //<co id="co_enforceSize"/> 
  @Pattern(regexp="^[a-zA-Z0-9]+$",
          message="Nazwa u�ytkownika musi si� sk�ada� ze znak�w alfanumerycznych bez spacji.")  //<co id="co_noSpaces"/>
  private String username;  
  
  @Size(min=6, max=20,
          message="Has�o nie mo�e by� kr�tsze ni� 6 znak�w.") //<co id="co_enforceSize"/>
  private String password;

  @Size(min=3, max=50, message=
      "Imi� i nazwisko musi si� sk�ada� z co najmniej 3 i nie wi�cej ni� 50 znak�w.")    //<co id="co_enforceSize"/>   
  private String fullName;
  
  @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", 
          message="Niepoprawny adres e-mail.") //<co id="co_emailPattern"/>
  private String email;  
  //<end id="java_SpitterValidated" /> 

  private boolean updateByEmail;
  
  @Id
  @GeneratedValue(strategy = AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name="username", unique=true)
  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Column(name="password")
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  @Column(name="fullname")
  public String getFullName() {
    return fullName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name="email")
  public String getEmail() {
    return email;
  }

  public void setUpdateByEmail(boolean updateByEmail) {
    this.updateByEmail = updateByEmail;
  }

  @Column(name="update_by_email")
  public boolean isUpdateByEmail() {
    return updateByEmail;
  }

  @Transient
  @JsonIgnore
  public List<Spittle> getRecentSpittles() {
    Spittle spittle = new Spittle();
    spittle.setId(999L);
    spittle.setSpitter(this);
    spittle.setText("TEST SPITTLE #99");
    spittle.setWhen(new Date());
    return asList(spittle);
  }
  
  // plumbing
  @Override
  public boolean equals(Object obj) {
    return reflectionEquals(this, obj);
  }
  
  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }
  
  @Override
  public String toString() {
    return reflectionToString(this);
  }
}

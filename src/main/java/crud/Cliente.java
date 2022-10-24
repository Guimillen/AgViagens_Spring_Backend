package crud;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cliente {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(name="primeiro_nome")
private String primeiroNome;
@Column(name="ultimo_nome")
private String ultimoNome;
@Column(name="email_id")
private String emailId;

public Cliente() {
}
public Cliente(String primeiroNome, String ultimoNome, String emailId) {
super();
this.primeiroNome = primeiroNome;
this.ultimoNome = ultimoNome;
this.emailId = emailId;
}
public long getId() {
return id;
}
public void setId(long id) {
this.id = id;
}
public String getPrimeiroNome() {
return primeiroNome;
}
public void setPrimeiroNome(String primeiroNome) {
this.primeiroNome = primeiroNome;
}
public String getUltimoNome() {
return ultimoNome;
}
public void setUltimoNome(String ultimoNome) {
this.ultimoNome = ultimoNome;
}
public String getEmailId() {
return emailId;
}
public void setEmailId(String emailId) {
this.emailId = emailId;
}
}

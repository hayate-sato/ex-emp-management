package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InsertAdministratorForm {

	@NotBlank(message = "名前は必須です")
	private String name;
	@Size(min = 1, max = 127, message = "Eメールは1文字以上１２７文字以内で入力してください")
	@Email(message = "Eメールの形式が不正です")
	private String mailAddress;
	@Size(min = 1, max = 127, message = "パスワードは1文字以上１２７文字以内で入力してください")
	private String password;

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

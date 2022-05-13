package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Administrator> ADMINISTRATION_ROW_MAPPER = new BeanPropertyRowMapper<>(
			Administrator.class);

	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);

		String insertSql = "INSERT INTO administrators(id,name,mailAddress,password)"
				+ "VALUES(:id,:name,:mailAddress,:password)";
		template.update(insertSql, param);
	}

	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
		String sql = "SELECT id,name,mail_address,password FROM administrators WHERE mail_address=:mailAddress OR password=:password ";
		SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress);

		List<Administrator> administratorList = template.query(sql, param, ADMINISTRATION_ROW_MAPPER);
		if (administratorList.size() == 0) {
			return null;
		}
		return administratorList.get(0);
	}
}

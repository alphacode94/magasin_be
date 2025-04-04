package com.magasin.serviceImpl;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.magasin.dto.UserDTO;
import com.magasin.models.LoginHistory;
import com.magasin.models.Users;
import com.magasin.repository.LoginHistoryRespository;
import com.magasin.repository.UserRespository;
import com.magasin.service.UserService;
import com.magasin.utils.TokenUtils;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRespository userRepository;

	@Autowired
	LoginHistoryRespository loginhistoryRepository;

	/*
	 * @Autowired PasswordEncoder passwordEncoder;
	 */

	public String signIn(jakarta.servlet.http.HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		String authHeaders = request.getHeader(HttpHeaders.AUTHORIZATION).replace("Basic ", "");
		byte[] decodedBytes = Base64.getDecoder().decode(authHeaders);
		String decodedString = new String(decodedBytes);
		String[] tok = decodedString.split(":");
		String username = tok[0];
		String password = tok[1];
		String ipAddress = request.getRemoteAddr();
//		String LocalSessionId = TokenUtils.getSessionIdFromToken();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hashedPwd = passwordEncoder.encode(password);
//		Optional<Users> userAccountOpt = userRepository.findByUsernameAndPassword(username, hashedPwd);
		Optional<Users> userAccountOpt = userRepository.findByUsername(username);

		if (userAccountOpt.isPresent()) {
			boolean matches = passwordEncoder.matches(password, userAccountOpt.get().getPassword());
			if (matches) {
				/// login history
				LoginHistory loginHistory = new LoginHistory();
				loginHistory.setActive(true);
				loginHistory.setLoginDatetime(LocalDate.now());
				loginHistory.setLoginIp(ipAddress);
				loginHistory.setUsers(userAccountOpt.get());
				loginhistoryRepository.save(loginHistory);
				return TokenUtils.generateJWTUserToken(userAccountOpt.get(), ipAddress);
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public UserDTO create(MultipartFile[] files, UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO update(MultipartFile[] files, UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}
}

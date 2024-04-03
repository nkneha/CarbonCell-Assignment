package com.example.CarbonCellAssignment.service;

import com.example.CarbonCellAssignment.model.Token;
import com.example.CarbonCellAssignment.model.TokenType;
import com.example.CarbonCellAssignment.model.User;
import com.example.CarbonCellAssignment.repository.IUserRepository;
import com.example.CarbonCellAssignment.repository.TokenRepository;
import com.example.CarbonCellAssignment.security.userDetails.CustomUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TokenService implements ITokenService {
    private final TokenRepository tokenRepository;
    private final IUserRepository userRepository;

    @Override
    public void buildTokenDetails(String token, CustomUserDetails userDetail) {

        var getUser = userRepository.findByEmail(userDetail.getEmail()).orElse(null);

        var jwtToken = Token.builder()
                .user(getUser)
                .token(token)
                .tokenType(TokenType.BEARER)
                .isLogout(false)
                .build();

        assert getUser != null;
        revokedAllTokenByUser(getUser);
        tokenRepository.save(jwtToken);
    }

    private void revokedAllTokenByUser(User getUser) {
        List<Token> validTokenListByUser = tokenRepository.findALlTokenByUser(getUser.getUserId());

        if(!validTokenListByUser.isEmpty()){
            validTokenListByUser.forEach(t->t.setLogout(true));
        }
        tokenRepository.saveAll(validTokenListByUser);
    }
}

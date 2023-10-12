# spring-security-formLogin
관리자 form Login

사용 언어
```
- JAVA 8
```

사용 기술
```
- springboot
- Mysql
- jpa
```

라이브러리
```
- lombok
- gradle
```


인증
```java
//Ajax용 토큰을 만들어서 해당 토큰을 통해 인증처리
AjaxAuthenticationToken ajaxAuthenticationToken = new AjaxAuthenticationToken(accountApiRequest.getUserId(), accountApiRequest.getPassword());

```

인증 요청 객체
```java 
@Override
@Transactional
//AuthenticationManager로 부터 인증요청한 객체 들어온다
public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName(); // 인증전 사용자가 입력한 id
    String password = (String)authentication.getCredentials(); // 인증전 사용자가 입력한 pw

    //customerUserDetailsService 부터 객체 얻어오는데 이는
    //인증된 UserDetails 타입의 CustomUserDetails 객체
    CustomUserDetails accountContext = (CustomUserDetails) customerUserDetailsService.loadUserByUsername(username);

    //패스워드 검증 (암호화 되지않은 password와 암호화된 password 비교)
    if(!passwordEncoder.matches(password,accountContext.getPassword())){
       throw new BadCredentialsException("BadCredentialsException");
    }

    //pw 검증 완료된 인증된 account 객체, pw는 null처리,
    AjaxAuthenticationToken authenticationToken = new AjaxAuthenticationToken(accountContext.getAccount(), null,accountContext.getAuthorities());

    return authenticationToken;
}

```

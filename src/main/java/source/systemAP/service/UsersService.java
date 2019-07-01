package source.systemAP.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import source.systemAP.dao.LoginDao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by кирюха on 18.07.2018.
 */
@Service
public class UsersService implements UserDetailsService, Serializable {


    @Autowired
    private LoginDao loginDao;

    @Override
    public UserDetails loadUserByUsername(final String username) {


        return new UserDetails() {

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public String getPassword() {

                try {


                    System.out.println(loginDao.getUserPasswordHash(username));
                    System.out.println(username);
                    return loginDao.getUserPasswordHash(username);

                } catch (Exception e) {

                }
                return null;
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();

                try {
                    //получаем роль пользователя по имени пользователя
                    auths.add(new SimpleGrantedAuthority(loginDao.getUserRole(username)));

                } catch (Exception e) {

                }

                return auths;
            }
        };
    }

    public LoginDao getContentService() {
        return loginDao;
    }

    public void setContentService(LoginDao contentService) {
        this.loginDao = contentService;
    }
}
package com.sp.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

@Data
public class AdminUserInfo implements UserDetails {

    //계정 아이디
    private String id;
    //계정 비밀번호
    private String password;
    //계정 사용자 이름
    private String name;
    //계정이 가지고 있는 권한 목록
    private Set<GrantedAuthority> authorities;


    public AdminUserInfo(String id, String password, String name, Collection<? extends GrantedAuthority> authorities) {

        this.id = id;

        this.password = password;

        this.name = name;

        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));

    }


    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;

    }


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {

        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));

    }


    @Override

    public String getPassword() {


        return password;

    }

    @Override

    public String getUsername() {


        return getId();

    }

    @Override

    public boolean isAccountNonExpired() {


        return true;

    }

    @Override

    public boolean isAccountNonLocked() {


        return true;

    }

    @Override

    public boolean isCredentialsNonExpired() {


        return true;

    }

    @Override

    public boolean isEnabled() {


        return true;

    }


    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {

        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");


        SortedSet<GrantedAuthority> sortedAuthorities =

                new TreeSet<GrantedAuthority>(new AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {

            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");

            sortedAuthorities.add(grantedAuthority);

        }

        return sortedAuthorities;

    }


    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {

        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        public int compare(GrantedAuthority g1, GrantedAuthority g2) {


            if (g2.getAuthority() == null) {

                return -1;

            }

            if (g1.getAuthority() == null) {

                return 1;

            }

            return g1.getAuthority().compareTo(g2.getAuthority());

        }

    }

}

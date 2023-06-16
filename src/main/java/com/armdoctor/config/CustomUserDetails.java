package com.armdoctor.config;

import com.armdoctor.exceptions.DoctorNotFoundException;
import com.armdoctor.model.DoctorEntity;
import com.armdoctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        DoctorEntity doctorEntity = null;
        try {
            List<DoctorEntity> doctorEntityList = doctorRepository.getByEmail(s);
            doctorEntity = doctorEntityList.get(0);
        } catch (Exception e) {
            throw new DoctorNotFoundException("Wrong email " + s);
        }
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        return new User(doctorEntity.getEmail(), doctorEntity.getPassword(), grantedAuthorities);
    }
}

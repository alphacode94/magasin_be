package com.magasin.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.magasin.models.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AdminConfig {

	private List<Users> admins = new ArrayList<>();

}

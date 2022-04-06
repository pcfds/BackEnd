package com.clase31SORM.SORM.Repository;

import com.clase31SORM.SORM.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}

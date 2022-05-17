package com.empresa.apiRest_DataPrint.repository;

import com.empresa.apiRest_DataPrint.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* import com.empresa.apiRest_DataPrint.model.Usuarios;
 */

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    
}

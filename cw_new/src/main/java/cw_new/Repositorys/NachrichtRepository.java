package cw_new.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import  cw_new.entitys.Nachricht;


public interface NachrichtRepository  extends JpaRepository<Nachricht, Long>{

}

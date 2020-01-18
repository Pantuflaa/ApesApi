package com.example.demo.entidades;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;


@Table(name="FEEDBACK")
@Entity
public class Feedback {
    @Id
    @GenericGenerator(name="incrementfeedback", strategy="increment")
    @GeneratedValue(generator="incrementfeedback")
    @Column(name="id_feedback")
    long id;
    
    
    @Column(name="id_usuario")
    long idUsuariof;

    
    @Column(name="id_consulta")
    long idConsultaf;

    
    @Column(name="id_tecnico")
    long idTecnicof;

    @Column(name="comentario")
    String comentario;




    @Column(name="rating")
    int rating;
    
    
    /**
     * @return the descripcion
     */
        public Feedback(){
            
        }
        public Feedback(long id, long idUsuario, long idConsulta, long idTecnico,String comentario,int rating){
            this.id=id;
            this.idUsuariof=idUsuario;
            this.idConsultaf=idConsulta;
            this.idTecnicof=idTecnico;
            this.comentario=comentario;
            this.rating=rating;
        }
        public long getId() {
            return this.id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public long getIdUsuario() {
            return this.idUsuariof;
        }
        public void setIdUsuario(long idUsuario) {
            this.idUsuariof = idUsuario;
        }
        public long getIdConsulta() {
            return this.idConsultaf;
        }
        public void setIdConsulta(long idConsulta) {
            this.idConsultaf = idConsulta;
        }
        public long getIdTecnico() {
            return this.idTecnicof;
        }
        public void setIdTecnico(long idTecnico) {
            this.idTecnicof = idTecnico;
        } 
        public String getComentario() {
            return this.comentario;
        }
        public void setComentario(String comentario) {
            this.comentario = comentario;
        }
        public int getRating() {
            return this.rating;
        }
        public void setRating(int rating) {
            this.rating = rating;
        }
        
}



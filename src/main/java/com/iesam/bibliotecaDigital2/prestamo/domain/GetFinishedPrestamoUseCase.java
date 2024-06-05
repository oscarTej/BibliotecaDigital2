package com.iesam.bibliotecaDigital2.prestamo.domain;

import java.util.ArrayList;
import java.util.List;

public class GetFinishedPrestamoUseCase {



        private final PrestamoRespository prestamoRespository;

        public GetFinishedPrestamoUseCase(PrestamoRespository prestamoRespository) {
            this.prestamoRespository = prestamoRespository;
        }

        public List<Prestamo> execute (){
            List<Prestamo> prestamos = prestamoRespository.allPrestamos();
            List<Prestamo> prestamosFinalizados = new ArrayList<>();
            for (Prestamo prestamo : prestamos){
                if (prestamo.estadoDelPrestamo == false){
                    prestamosFinalizados.add(prestamo);
                }
            }
            return prestamosFinalizados;
        }
}

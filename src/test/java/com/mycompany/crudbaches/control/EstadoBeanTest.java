/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudbaches.control;

import com.mycompany.crudbaches.entity.Estado;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Matchers;
import org.mockito.Mockito;

/**
 *
 * @author josem
 */
public class EstadoBeanTest {

    public EstadoBeanTest() {
    }

    /**
     * Test of crear method, of class EstadoBean.
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        Estado nuevo = new Estado();
        EstadoBean cut = new EstadoBean();
        assertThrows(IllegalArgumentException.class, () -> {
            cut.crear(null);
        });
        assertThrows(IllegalStateException.class, () -> {
            cut.crear(nuevo);
        });
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        cut.em = mockEM;
        cut.crear(nuevo);
        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.crear(nuevo);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        //EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");

        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findByid method, of class EstadoBean.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EstadoBean cut = new EstadoBean();
        Estado esperado = new Estado();
        Mockito.when(mockEM.find(Estado.class, id)).thenReturn(esperado);
        assertThrows(IllegalArgumentException.class, () -> {
            cut.findByid(null);
        });
        assertThrows(IllegalStateException.class, () -> {
            cut.findByid(id);
        });

        cut.em = mockEM;
        Estado encontrado = cut.findByid(id);
        assertNotNull(encontrado);
        assertEquals(esperado, encontrado);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findByid(id);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

    }

    /**
     * Test of findAll method, of class EstadoBean.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EstadoBean cut = new EstadoBean();
        List esperado = null;
        
        assertThrows(IllegalStateException.class, () -> {
            cut.findAll();
        });

        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        
        TypedQuery TQ = cut.generarConsultaBase(mockEM);
        //List mockList=Mockito.mock(List.class);

        Mockito.when(TQ).thenReturn(mockTQ);
        Mockito.when(mockTQ.getResultList()).thenReturn(esperado);
        cut.em = mockEM;
        List encontrado = cut.findAll();
        assertNotNull(encontrado);
        assertEquals(esperado, encontrado);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.contar();
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

    }

    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");

    }

    @Test
    public void testContar() throws Exception {
        System.out.println("contar");
        Long esperado = Long.valueOf(1);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);

        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Long.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);
        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalArgumentException.class, () -> {
            cut.contar();
        });

        cut.em = mockEM;
        Long resultado = cut.contar();
        assertNotNull(resultado);
        assertEquals(esperado, resultado);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.contar();
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

    }

    /**
     * Test of Modificar method, of class EstadoBean.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("Modificar");
        int id = 1;
        EntityManager mockEM = Mockito.mock(EntityManager.class);

        Estado nuevo = new Estado(2);
        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalArgumentException.class, () -> {
            cut.Modificar(null, id);
        });

        assertThrows(IllegalStateException.class, () -> {
            cut.Modificar(nuevo, id);
        });

        cut.em = mockEM;
        cut.Modificar(nuevo, id);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.Modificar(nuevo, id);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of Eliminar method, of class EstadoBean.
     */
    @Test
    public void testeliminar() throws Exception {
        System.out.println("eliminar");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EstadoBean cut = new EstadoBean();
        cut.em = mockEM;
        Estado eliminado = new Estado(1);
        cut.eliminar(eliminado);
        Mockito.verify(mockEM, Mockito.times(1)).remove(Matchers.any());

        try {
            cut.eliminar(null);
            fail("el argumento era nulo");

        } catch (IllegalArgumentException e) {

        }
        try {
            cut.em = null;
            cut.eliminar(eliminado);
            fail("el entity era nulo");

        } catch (IllegalStateException e) {

        }

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.eliminar(eliminado);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

    }

    /**
     * Test of getEntityManager method, of class EstadoBean.
     */
    @Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");

    }
}

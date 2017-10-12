/**************
 Implementado por:
 Pedro Hurtado Gozález
 **************/

package Monitorizacion;

import static org.junit.Assert.*;
import org.junit.Test;
import ControlVelocidad.Eje;

public class NotificacionesTest {
	Notificaciones notificaciones;
	
	@Test
	public void testConstructor(){
		notificaciones = new Notificaciones();
		assertNotNull(notificaciones);
		assertTrue(notificaciones instanceof Notificaciones);
	}

	@Test
	public void testComprobarNotificaciones() {
		Eje eje;
		Monitorizacion monitor;
		eje = new Eje();
		assertNotNull(eje);
		monitor = new Monitorizacion(eje);
		assertNotNull(monitor);
		Notificaciones notif = monitor.getNotificaciones();
		assertNotNull (notif);
		
		assertEquals(Notificaciones.NOTIFACEITE, notif.leerNotifAceite());
		assertEquals(Notificaciones.NOTIFPASTILLAS, notif.leerNotifPastillas());
		assertEquals(Notificaciones.NOTIFREV, notif.leerNotifRevision());
		
		assertEquals(false, notif.notificarAceite());
		assertEquals(false, notif.notificarPastillas());
		assertEquals(false, notif.notificarRevision());

	}
	
	@Test
	public void testGetter(){
		notificaciones = new Notificaciones();
		assertNotNull(notificaciones.leerNotifAceite());
		assertNotNull(notificaciones.leerNotifPastillas());
		assertNotNull(notificaciones.leerNotifRevision());
	}
	
	@Test
	public void testLectura(){
		notificaciones = new Notificaciones();
		assertNotNull(notificaciones.leerNotifAceite());
		assertNotNull(notificaciones.leerNotifPastillas());
		assertNotNull(notificaciones.leerNotifRevision());
	}

}

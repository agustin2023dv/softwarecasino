
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

class Main {

	public static void main(String[] args) {

		
		
		// Clientes

		Cliente cliente1 = new Cliente("1", "nombre1", "apellido1", new Date(06 - 05 - 2023), "12341",
				"mail1@gmail.com", "1", 1000.00);
		Cliente cliente2 = new Cliente("2", "nombre2", "apellido2", new Date(06 - 05 - 2023), "12342",
				"mail2@gmail.com", "2", 1000.00);
		Cliente cliente3 = new Cliente("3", "nombre3", "apellido3", new Date(06 - 05 - 2023), "12343",
				"mail3@gmail.com", "3", 1000.00);
		Cliente cliente4 = new Cliente("4", "nombre4", "apellido4", new Date(06 - 05 - 2023), "12344",
				"mail4@gmail.com", "4", 1000.00);
		Cliente cliente5 = new Cliente("5", "nombre5", "apellido5", new Date(06 - 05 - 2023), "12345",
				"mail5@gmail.com", "5", 1000.00);

		// Administrador

		Administrador admin1 = new Administrador("6", "nombre6", "apellido6", new Date(06 - 05 - 2023), "12346",
				"mail6@gmail.com", 1);
		Administrador admin2 = new Administrador("7", "nombre7", "apellido7", new Date(06 - 05 - 2023), "12347",
				"mail7@gmail.com", 2);
		Administrador admin3 = new Administrador("8", "nombre8", "apellido8", new Date(06 - 05 - 2023), "12348",
				"mail8@gmail.com", 3);

		// Empleado caja

		EmpleadoCaja empleadoCaja1 = new EmpleadoCaja("9", "nombre9", "apellido9", new Date(06 - 05 - 2023), "12349",
				"mail9@gmail.com", "1", "Caja", 1);
		EmpleadoCaja empleadoCaja2 = new EmpleadoCaja("10", "nombre10", "apellido10", new Date(06 - 05 - 2023),
				"123410", "mail10@gmail.com", "2", "Caja", 2);
		EmpleadoCaja empleadoCaja3 = new EmpleadoCaja("11", "nombre11", "apellido11", new Date(06 - 05 - 2023),
				"123411", "mail11@gmail.com", "3", "Caja", 3);

		// Empleado tecnico

		Tecnico tecnico1 = new Tecnico("12", "nombre12", "apellido12", new Date(06 - 05 - 2023), "123412",
				"mail12@gmail.com", "4", "Tecnico", 1);
		Tecnico tecnico2 = new Tecnico("13", "nombre13", "apellido13", new Date(06 - 05 - 2023), "123413",
				"mail13@gmail.com", "5", "Tecnico", 2);
		Tecnico tecnico3 = new Tecnico("14", "nombre14", "apellido14", new Date(06 - 05 - 2023), "123414",
				"mail14@gmail.com", "6", "Tecnico", 3);

		// Empleado maquina

		EmpleadoMaquina empleadoMaquina1 = new EmpleadoMaquina("15", "nombre15", "apellido15", new Date(06 - 05 - 2023),
				"123415", "mail15@gmail.com", "7", "Maquina", "1");
		EmpleadoMaquina empleadoMaquina2 = new EmpleadoMaquina("16", "nombre16", "apellido16", new Date(06 - 05 - 2023),
				"123416", "mail16@gmail.com", "8", "Maquina", "2");
		EmpleadoMaquina empleadoMaquina3 = new EmpleadoMaquina("17", "nombre17", "apellido17", new Date(06 - 05 - 2023),
				"123417", "mail17@gmail.com", "9", "Maquina", "3");

		// Array de todos los usuarios

		ArrayList<Usuario> usuarioEjemplo = new ArrayList<Usuario>();

		usuarioEjemplo.add(cliente1);
		usuarioEjemplo.add(cliente2);
		usuarioEjemplo.add(cliente3);
		usuarioEjemplo.add(cliente4);
		usuarioEjemplo.add(cliente5);
		usuarioEjemplo.add(admin1);
		usuarioEjemplo.add(admin2);
		usuarioEjemplo.add(admin3);
		usuarioEjemplo.add(empleadoCaja1);
		usuarioEjemplo.add(empleadoCaja2);
		usuarioEjemplo.add(empleadoCaja3);
		usuarioEjemplo.add(tecnico1);
		usuarioEjemplo.add(tecnico2);
		usuarioEjemplo.add(tecnico3);
		usuarioEjemplo.add(empleadoMaquina1);
		usuarioEjemplo.add(empleadoMaquina2);
		usuarioEjemplo.add(empleadoMaquina3);
		
		// Array clientes

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);

		// Maquinas
		
		ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
		
		Maquina maquina1 = new Maquina(1, 100);
		Maquina maquina2 = new Maquina(2, 100);
		Maquina maquina3 = new Maquina(3, 100);
		
		maquinas.add(maquina1);
		maquinas.add(maquina2);
		maquinas.add(maquina3);		
		
		// Juegos

		ArrayList<Juego> juegos = new ArrayList<Juego>();

		Juego caraOCruz = new Juego(1, "Cara o cruz",
				"Cara o Cruz es un juego de azar en el que se lanza una moneda para predecir el resultado: cara o cruz.",
				1, 6, maquina1);
		Juego dados = new Juego(2, "Dados",
				"Dados es un juego de azar en el que se lanzan dados para predecir el resultado de la suma de los números obtenidos",
				1, 6, maquina2);
		Juego blackjack = new Juego(3, "Blackjack",
				"Blackjack es un juego de cartas en el que los jugadores intentan obtener una mano con un valor total cercano a 21 sin pasarse.",
				1, 6, maquina3);

		juegos.add(caraOCruz);
		juegos.add(dados);
		juegos.add(blackjack);
		
		// Cajas

		ArrayList<Caja> cajas = new ArrayList<Caja>();
		
		Caja caja1 = new Caja(1, 100.00, 50.0, null);
		Caja caja2 = new Caja(2, 1000.00, 500.0, null);
		Caja caja3 = new Caja(3, 10000.00, 5000.0, null);
		
		cajas.add(caja1);
		cajas.add(caja2);
		cajas.add(caja3);

		
		//-------------------------------------------------------------------------------------------------------------

		// Arreglo de juegos

		String[] opcionesJuegos = new String[juegos.size()];


		// Agregacion del nombre de los juegos al array opcionesJuegos

		for (int i = 0; i < juegos.size(); i++) {
			opcionesJuegos[i] = juegos.get(i).getNombre();
		}



		// INICIO

		// Pantalla de Bienvenida
		String rutaImagenInicio = "img/casinoInicio.jpg";
		ImageIcon iconoInicio = new ImageIcon(rutaImagenInicio);
		JOptionPane.showMessageDialog(null, "Bienvenido al casino Jocker",
				"Casino Jocker", JOptionPane.PLAIN_MESSAGE, iconoInicio);


		// Pantalla pre login . Seleccion de tipo de usuario

		String rutaImagenPreLogin = "img/userPreLogin.png";
		ImageIcon iconoPreLogin = new ImageIcon(rutaImagenPreLogin);

		String[] opciones = { "Cliente", "Empleado", "Administrador" };
		int choice = JOptionPane.showOptionDialog(
						null,
						"Por favor seleccione su tipo de usuario. Gracias.",
						"Seleccion tipo de usuario",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						iconoPreLogin,
						opciones,
						opciones[0]);

		// Botones de usuario

		String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre:");
		String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");

		Usuario actual = null;

		boolean quiereJugar = true;

		switch (choice) {
			case 0: // Cliente

				for (Cliente cliente : clientes) {
					if (cliente.getNombre().equalsIgnoreCase(nombreIngresado) &&
							cliente.getContrasena().equalsIgnoreCase(contrasena)) {
						actual = cliente;
					}
				}

				if (actual == null) {
					JOptionPane.showMessageDialog(null, "El usuario o la contraseña ingresada es incorrecta.");
				} else if (actual instanceof Cliente) {
					actual.login(contrasena);
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
				} else {
					JOptionPane.showMessageDialog(null,
							"Lo sentimos, solo los Clientes pueden iniciar sesión por este sistema.");
				}


				int choiceCliente =
						JOptionPane.showOptionDialog(null, "Seleccione un juego", "Juegos",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesJuegos,
								opcionesJuegos[0]);
				boolean resultado;


				double apuesta;
				apuesta = Double.parseDouble(JOptionPane.showInputDialog(null, "Cuánto desea apostar?"
						));

				switch (choiceCliente){
					case 0:

						// Se elige primer juego
						while(quiereJugar) {




							resultado = juegos.get(0).generarResultado();

							if (resultado) {
								JOptionPane.showMessageDialog(null, "Has ganado "+ apuesta*4+ " pesos! ");

							} else {
								JOptionPane.showMessageDialog(null, "Has perdido.");
							}
							int seguirJugando = JOptionPane.showOptionDialog(null,
									"Quiere seguir jugando?", "Casino Jocker",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null
									);

							if(seguirJugando == 1){
								JOptionPane.showMessageDialog(null,"Gracias por jugar!");
								quiereJugar = false;
								break;
							}
							else{
								choiceCliente =
										JOptionPane.showOptionDialog(null, "Seleccione un juego", "Juegos",
												JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesJuegos,
												opcionesJuegos[0]);
							}

						}
					case 1:
						// Se elige segundo juego

						break;

					case 3:

						// Se elige tercer juego

						break;
				}

				break;


			case 1: // Empleado


				for (Usuario usuario : usuarioEjemplo) {
					if (usuario.getNombre().equalsIgnoreCase(nombreIngresado) && usuario.getContrasena().equalsIgnoreCase(contrasena)) {
						actual = usuario;
					}
				}

				if (actual == null) {
					JOptionPane.showMessageDialog(null,
							"El usuario o la contraseña ingresada es incorrecta.");
				} else if (actual instanceof Empleado) {
					actual.login(contrasena);
					JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
				} else {
					JOptionPane.showMessageDialog(null,
							"Lo siento, solo los Empleados pueden iniciar sesión por este sistema.");
				}
				break;

			case 2: // Admin


				for (Usuario usuario : usuarioEjemplo) {
					if (usuario.getNombre().equalsIgnoreCase(nombreIngresado) &&
							usuario.getContrasena().equalsIgnoreCase(contrasena)) {
						actual = usuario;
					}
				}

				if (actual == null) {
					JOptionPane.showMessageDialog(null,
							"El usuario o la contraseña ingresada es incorrecta.");
				} else if (actual instanceof Administrador) {
					actual.login(contrasena);
					JOptionPane.showMessageDialog(null,
							"Inicio de sesión exitoso.");

					// CHOICE ADMIN
					boolean continuar = true;

					while (continuar) {

						String[] opcionesAdministrador = { "Caja", "Juego", "Maquina", "Usuario", "Visualizar Cliente", "Logout" };

						int choiceAdministrador =
								JOptionPane.showOptionDialog(null, "Seleccione su Usuario", "Selección de Usuario",
										JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesAdministrador,
										opcionesAdministrador[5]);

						if (choiceAdministrador == 0) {
							JOptionPane.showMessageDialog(null, "Eligió Caja");

							int visualizarCaja = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Caja"));

							boolean encontrado = false;

							for (Caja caja : cajas) {
								if (caja.getIdCaja() == visualizarCaja) {
									encontrado = true;
									admin1.visualizarCaja(caja);
									JOptionPane.showMessageDialog(null, "ID : " + caja.getIdCaja() +
											" | Saldo Inicial: " + caja.getSaldoInicial() + " | Saldo Actual: " + caja.getSaldoActual());
									break;
								}
							}

							if (!encontrado) {
								JOptionPane.showMessageDialog(null, "El ID " + visualizarCaja + " no existe.");
							}
						} else if (choiceAdministrador == 1) {
							JOptionPane.showMessageDialog(null, "Eligió Juego");

							String[] opcionesAdministradorJuego = { "Eliminar Juego", "Editar Juego", "Regresar" };
							int choiceAdministradorJuego = JOptionPane.showOptionDialog(null,
									"Seleccione su Usuario", "Selección de Usuario",
									JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesAdministradorJuego,
									opcionesAdministradorJuego[2]);

							if (choiceAdministradorJuego == 0) {
								JOptionPane.showMessageDialog(null, "Eligió Eliminar Juego");

								String eliminarJuego = JOptionPane.showInputDialog("Ingrese el nombre del juego a eliminar");

								boolean encontrado = false;

								for (Juego juego : juegos) {
									if (juego.getNombre().equalsIgnoreCase(eliminarJuego)) {
										encontrado = true;
										admin1.eliminarJuego(juego, juegos);
										JOptionPane.showMessageDialog(null, "El juego " + eliminarJuego +
												" fue eliminado con éxito.");
										break;
									}
								}

								if (!encontrado) {
									JOptionPane.showMessageDialog(null, "El juego " + eliminarJuego + " no existe.");
								}
							} else if (choiceAdministradorJuego == 1) {
								JOptionPane.showMessageDialog(null, "Eligió Editar Juego");

								String editarJuego = JOptionPane.showInputDialog("Ingrese el nombre del juego a editar");

								boolean encontrado = false;

								for (Juego juego : juegos) {
									if (juego.getNombre().equalsIgnoreCase(editarJuego)) {
										encontrado = true;
										String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del juego");
										String nuevoDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del juego");
										int nuevoJugMin =
												Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de jugadores mínimos del juego"));
										int nuevoJugMax =
												Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de jugadores máximos del juego"));
										admin1.editarJuego(juego, nuevoNombre, nuevoDescripcion, nuevoJugMin, nuevoJugMax);
										JOptionPane.showMessageDialog(null,
												"Los nuevos datos del juego son: \n" + nuevoNombre + " || "
														+ nuevoDescripcion + " || " + nuevoJugMin + " || " + nuevoJugMax);
										break;
									}
								}

								if (!encontrado) {
									JOptionPane.showMessageDialog(null, "El juego " + editarJuego + " no existe.");
								}
							} else if (choiceAdministradorJuego == 2) {
								JOptionPane.showMessageDialog(null, "Eligió Regresar");
							} else {
								JOptionPane.showMessageDialog(null, "Acaba de cerrar la app");
							}

							if (choiceAdministradorJuego == 3) {
								continuar = true;
							}
						} else if (choiceAdministrador == 2) {
							JOptionPane.showMessageDialog(null, "Eligió Maquina");

							int seleccionarMaquina =
									Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la máquina a la que agregará un juego."));

							boolean encontrado = false;

							for (Maquina maquina : maquinas) {
								if (maquina.getIdMaquina() == seleccionarMaquina) {
									encontrado = true;
									String seleccionarJuego = JOptionPane.showInputDialog("Ingrese el nombre del juego que agregará a la máquina.");
									Juego juego = null;

									for (Juego j : juegos) {
										if (j.getNombre().equalsIgnoreCase(seleccionarJuego)) {
											juego = j;
											break;
										}
									}

									if (juego != null) {
										admin1.agregarJuegoaMaquina(juego, maquina);
										JOptionPane.showMessageDialog(null, "El juego " + seleccionarJuego
												+ " fue agregado con éxito a la máquina " + seleccionarMaquina + ".");
									} else {
										JOptionPane.showMessageDialog(null, "El juego " + seleccionarJuego
												+ " no existe.");
									}
								}
							}

							if (!encontrado) {
								JOptionPane.showMessageDialog(null, "El ID " + seleccionarMaquina
										+ " de máquina no existe.");
							}
						} else if (choiceAdministrador == 3) {
							JOptionPane.showMessageDialog(null, "Eligió Usuario");

							String eliminarUsuario = JOptionPane.showInputDialog("Ingrese el ID del Usuario a eliminar");
							boolean encontrado = false;

							for (Usuario usuario : usuarioEjemplo) {
								if (usuario.getIdUsuario().equalsIgnoreCase(eliminarUsuario)) {
									encontrado = true;
									admin1.eliminarUsuario(usuario, usuarioEjemplo);
									JOptionPane.showMessageDialog(null, "El Usuario con ID "
											+ eliminarUsuario + " fue eliminado con éxito.");
									break;
								}
							}

							if (!encontrado) {
								JOptionPane.showMessageDialog(null, "El ID " + eliminarUsuario + " no existe.");
							}
						} else if (choiceAdministrador == 4) {
							JOptionPane.showMessageDialog(null, "Eligió Visualizar Cliente");

							String visualizarCliente = JOptionPane.showInputDialog("Ingrese el ID del Cliente");
							boolean encontrado = false;

							for (Cliente cliente : clientes) {
								if (cliente.getIdCliente().equalsIgnoreCase(visualizarCliente)) {
									encontrado = true;
									admin1.revisarCuentaCliente(cliente);
									JOptionPane.showMessageDialog(null, "Nombre: " + cliente.getNombre() +
											" | Apellido: " + cliente.getApellido() + " | Fecha de nacimiento: "
											+ cliente.getFecNacimiento() + " | Correo Electrónico: " + cliente.getCorreoElectronico());
									break;
								}
							}

							if (!encontrado) {
								JOptionPane.showMessageDialog(null, "El ID " + visualizarCliente + " no existe.");
							}
						} else if (choiceAdministrador == 5) {
							JOptionPane.showMessageDialog(null, "Eligió Logout");

						} else {
							JOptionPane.showMessageDialog(null, "Acaba de cerrar la app");
							continuar = false;
						}


						}
				} else {
					JOptionPane.showMessageDialog(null,
							"Lo siento, solo los administradores pueden iniciar sesión por este sistema.");
				}
				break;

			default:
				JOptionPane.showMessageDialog(null,
						"Acaba de cerrar la app");
				break;
		}

	/*	if (choice == 0) { // cliente
			
			JOptionPane.showMessageDialog(null, "Eligio Cliente");
			
			String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre:");
			String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
			Usuario actual = null;

			for (Usuario usuario : usuarioEjemplo) {

				if (usuario.getNombre().equalsIgnoreCase(nombreIngresado)
						&& usuario.getContrasena().equalsIgnoreCase(contrasena)) {
					actual = usuario;
				}

			}

			if (actual == null) {

				JOptionPane.showMessageDialog(null, "El usuario o la password ingresado es incorrecto.");

			} else if (actual instanceof Cliente) {
				actual.login(contrasena);
				JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
			} else {

				JOptionPane.showMessageDialog(null,
						"Lo siento, solo los Clientes pueden iniciar sesión por este sistema.");

			}
			
		} else if (choice == 1) { // empleado
		
			JOptionPane.showMessageDialog(null, "Eligio Empleado");
			
			String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre:");
			String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
			Usuario actual = null;

			for (Usuario usuario : usuarioEjemplo) {

				if (usuario.getNombre().equalsIgnoreCase(nombreIngresado)
						&& usuario.getContrasena().equalsIgnoreCase(contrasena)) {
					actual = usuario;
				}

			}

			if (actual == null) {

				JOptionPane.showMessageDialog(null, "El usuario o la password ingresado es incorrecto.");

			} else if (actual instanceof Empleado) {
				actual.login(contrasena);
				JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
			} else {

				JOptionPane.showMessageDialog(null,
						"Lo siento, solo los Empleados pueden iniciar sesión por este sistema.");

			}
			
			
			
			
		} else if (choice == 2) { // admin


			String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre:");
			String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
			Usuario actual = null;

			for (Usuario usuario : usuarioEjemplo) {

				if (usuario.getNombre().equalsIgnoreCase(nombreIngresado)
						&& usuario.getContrasena().equalsIgnoreCase(contrasena)) {
					actual = usuario;
				}

			}

			if (actual == null) {

				JOptionPane.showMessageDialog(null, "El usuario o la password ingresado es incorrecto.");

			} else if (actual instanceof Administrador) { 
				actual.login(contrasena);
				JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");

				// CHOICE ADMIN
				boolean continuar = true;

				while (continuar) {

					String[] opcionesAdministrador = { "Caja", "Juego", "Maquina", "Usuario", "Visualizar Cliente",
							"Logout" };
					int choiceAdministrador = JOptionPane.showOptionDialog(null, "Seleccione su Usuario",
							"Selección de Usuario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
							null, opcionesAdministrador, opcionesAdministrador[5]);

					if (choiceAdministrador == 0) {
						JOptionPane.showMessageDialog(null, "Eligio Caja");

						int visualizarCaja =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Caja"));
						
						boolean encontrado = false;
						
						for (Caja caja : cajas) {
							if (caja.getIdCaja() == visualizarCaja) {
								
								encontrado = true;
								
								admin1.visualizarCaja(caja);
								JOptionPane.showMessageDialog(null,
										"ID : " + caja.getIdCaja() + " | Saldo Inicial: " + caja.getSaldoInicial()
												+ " | Saldo Actual: " + caja.getSaldoActual());
								break;
							}

						}
						
						if (encontrado == false) {
							JOptionPane.showMessageDialog(null, "El ID " + visualizarCaja + " no existe.");
						}
						
						
					} else if (choiceAdministrador == 1) {
					
						JOptionPane.showMessageDialog(null, "Eligio Juego");

						String[] opcionesAdministradorJuego = { "Eliminar Juego", "Editar Juego", "Regresar" };
						int choiceAdministradorJuego = JOptionPane.showOptionDialog(null, "Seleccione su Usuario",
								"Selección de Usuario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
								null, opcionesAdministradorJuego, opcionesAdministradorJuego[2]);

						// CHOICE ADMIN JUEGO
						if (choiceAdministradorJuego == 0) {
							JOptionPane.showMessageDialog(null, "Eligio Eliminar Juego");

							String eliminarJuego = JOptionPane
									.showInputDialog("Ingrese el nombre del juego a eliminar");

							boolean encontrado = false;

							for (Juego juego : juegos) {
								if (juego.getNombre().equalsIgnoreCase(eliminarJuego)) {
									
									encontrado = true;
									
									admin1.eliminarJuego(juego, juegos);
									JOptionPane.showMessageDialog(null,
											"El juego " + eliminarJuego + " fue eliminado con exito.");
									break;
								}
							}
							
							if (encontrado == false) {
								JOptionPane.showMessageDialog(null, "El juego " + eliminarJuego + " no existe.");
							}

						} else if (choiceAdministradorJuego == 1) {
							JOptionPane.showMessageDialog(null, "Eligio Editar Juego");

							String editarJuego = JOptionPane
									.showInputDialog("Ingrese el nombre del juego a editar");

							boolean encontrado = false;
							
							for (Juego juego : juegos) {
								if (juego.getNombre().equalsIgnoreCase(editarJuego)) {
									
									encontrado = true;
									
									String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del juego");
									String nuevoDescripcion = JOptionPane
											.showInputDialog("Ingrese la nueva descripcion del juego");
									int nuevoJugMin = Integer.parseInt(JOptionPane
											.showInputDialog("Ingrese la nueva cantidad de jugadores minimos del juego"));
									int nuevoJugMax = Integer.parseInt(JOptionPane
											.showInputDialog("Ingrese la nueva cantidad de jugadores maximos del juego"));
		
									admin1.editarJuego(juego1, nuevoNombre, nuevoDescripcion, nuevoJugMin, nuevoJugMax);
		
									JOptionPane.showMessageDialog(null, "Los nuevos datos del juego son: \n" + nuevoNombre
											+ " || " + nuevoDescripcion + " || " + nuevoJugMin + " || " + nuevoJugMax);
									break;
								}
							}
							
							
							if (encontrado == false) {
								JOptionPane.showMessageDialog(null, "El juego " + editarJuego + " no existe.");
							}
							

						} else if (choiceAdministradorJuego == 2) {
							JOptionPane.showMessageDialog(null, "Eligio Regresar");

						} else {
							JOptionPane.showMessageDialog(null, "Acaba de cerrar la app");
						}

						if (choiceAdministradorJuego == 3) {
							continuar = true;
						}

						
						
					} else if (choiceAdministrador == 2) {
						JOptionPane.showMessageDialog(null, "Eligio Maquina");
						
						int seleccionarMaquina = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID la maquina a la que agregará un juego."));
						
						
						boolean encontrado = false;
						
						for(Maquina maquina : maquinas) {
							if (maquina.getIdMaquina() == seleccionarMaquina) {
								encontrado = true;
								String seleccionarJuego = JOptionPane.showInputDialog("Ingrese el nombre del juego que agregará a la maquina.");
								Juego juego = null;
								for (Juego j : juegos) {
									if (j.getNombre().equalsIgnoreCase(seleccionarJuego)) {
										juego = j;
										break;
									}
								}
								
								if (juego  != null) {
									admin1.agregarJuegoaMaquina(juego, maquina);
									JOptionPane.showMessageDialog(null, "El Juego " + seleccionarJuego + " fue agregado con exito a la maquina " + seleccionarMaquina);
								} else {
									JOptionPane.showMessageDialog(null, "El Juego " + seleccionarJuego + " no existe");
								}		
							}
						}
						
						if (encontrado == false) {
							JOptionPane.showMessageDialog(null, "El ID " + seleccionarMaquina + " de maquina no existe.");
						}

						
					} else if (choiceAdministrador == 3) {
						JOptionPane.showMessageDialog(null, "Eligio Usuario");
						
						String eliminarUsuario = JOptionPane
								.showInputDialog("Ingrese el ID del Usuario a eliminar");

						boolean encontrado = false;

						for (Usuario usuario : usuarioEjemplo) {
							if (usuario.getIdUsuario().equalsIgnoreCase(eliminarUsuario)) {
								
								encontrado = true;
								
								admin1.eliminarUsuario(usuario, usuarioEjemplo);
								JOptionPane.showMessageDialog(null,
										"El Usuario con ID " + eliminarUsuario + " fue eliminado con exito.");
								break;
							}
						}
						
						if (encontrado == false) {
							JOptionPane.showMessageDialog(null, "El ID " + eliminarUsuario + " no existe.");
						}
						
					} else if (choiceAdministrador == 4) {
						JOptionPane.showMessageDialog(null, "Eligio Visualizar Cliente");
						
						String visualizarCliente = JOptionPane.showInputDialog("Ingrese el ID del Cliente");
						
						boolean encontrado = false;
						
						for (Cliente cliente : clientes) {
							if (cliente.getIdCliente().equalsIgnoreCase(visualizarCliente)) {
								
								encontrado = true;
								
								admin1.revisarCuentaCliente(cliente);
								JOptionPane.showMessageDialog(null,
										"Nombre : " + cliente.getNombre() + " | Apellido: " + cliente.getApellido()
												+ " | Fecha de nacimiento: " + cliente.getFecNacimiento()
												+ " | Correo Electronico: " + cliente.getCorreoElectronico());
								break;
							}

						}
						
						if (encontrado == false) {
							JOptionPane.showMessageDialog(null, "El ID " + visualizarCliente + " no existe.");
						}
						
					} else if (choiceAdministrador == 5) {
						JOptionPane.showMessageDialog(null, "Eligio Logout");
						continuar = false;
					} else {
						JOptionPane.showMessageDialog(null, "Acaba de cerrar la app");
						continuar = false;
					}

					}
					

			} else {

				JOptionPane.showMessageDialog(null,
						"Lo siento, solo los administradores pueden iniciar sesión por este sistema.");

			}

			// aca termina admin
		} else { // cerro la app
			JOptionPane.showMessageDialog(null, "Acaba de cerrar la app");
		}

	}*/
}}
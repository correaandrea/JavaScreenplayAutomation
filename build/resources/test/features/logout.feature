Feature: Logout de usuario
  Como usuario de la aplicación ViveMedellín
  Necesito poder cerrar sesión
  Para proteger mi información y acceder como otro usuario

  Scenario: Cierre de sesión exitoso
    Given que estoy en la página de inicio de sesión
    When ingreso mis credenciales "test@example.com" y "password123" y doy click al boton iniciar sesion y doy click al boton de regreso
    And cierro la sesión
    Then debo volver a ver el botón de iniciar sesión en el home

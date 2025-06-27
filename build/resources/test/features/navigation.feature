Feature: Navegación en la aplicación
  Como usuario de la aplicación ViveMedellín
  Necesito poder navegar a diferentes secciones
  Para acceder a la información de Eventos, Comunidades y Valoraciones

  Scenario: Navegar a la sección de Eventos y Actividades
    Given que estoy en la página principal de la aplicación
    When navego a "Eventos y Actividades"
    Then debo ver la página de "Eventos y Actividades"

  Scenario: Navegar a la sección de Comunidades
    Given que estoy en la página principal de la aplicación
    When navego a "Comunidades"
    Then debo ver la página de "Comunidades"

  Scenario: Navegar a la sección de Valoraciones
    Given que estoy en la página principal de la aplicación
    When navego a "Valoraciones"
    Then debo ver la página de "Valoraciones"

  Scenario: Navegar de Login a Registro
    Given que estoy en la página de inicio de sesión
    When navego a la página de "Registro" desde Login
    Then debo ver la página de "Registro"

  Scenario: Navegar de Registro a Login
    Given que estoy en la página de registro
    When navego a la página de "Login" desde Registro
    Then debo ver la página de "Login"
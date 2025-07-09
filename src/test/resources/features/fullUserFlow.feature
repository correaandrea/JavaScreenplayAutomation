#Author: Andre
#Language: es

Feature: Flujo completo de usuario
  Como usuario nuevo,
  quiero registrarme y luego navegar entre secciones,
  para explorar la plataforma.

  Scenario: Un usuario nuevo se registra y navega entre las secciones
    Given que me encuentro en la página de inicio
    When navego a la pagina de registro
    And me registro con los datos: "Robinson", "Coronado", "robinson.coronado@udea.edu.co","segura123" y "segura123"
    Then deberia ser redirigido al home y ver mi sesion iniciada con el nombre "Robinson"
    When hago clic en la sección "Eventos y Actividades"
    And luego hago clic en la sección "Comunidades"
    And finalmente hago clic en la sección "Valoraciones"
    Then debo estar en la sección "Valoraciones"



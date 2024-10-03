import java.util.*;

class RedSocial {
    private Map<Usuario, List<Usuario>> listaAdyacencia;

    public RedSocial() {
        listaAdyacencia = new HashMap<>();
    }

    // Agregar un nuevo usuario
    public boolean agregarUsuario(String id) {
        Usuario usuario = new Usuario(id);
        if (listaAdyacencia.containsKey(usuario)) {
            System.out.println("Usuario '" + id + "' ya existe.");
            return false;
        }
        listaAdyacencia.put(usuario, new ArrayList<>());
        System.out.println("Usuario '" + id + "' agregado exitosamente.");
        return true;
    }

    // Seguir a otro usuario
    public boolean seguir(String seguidorId, String seguidoId) {
        Usuario seguidor = obtenerUsuario(seguidorId);
        Usuario seguido = obtenerUsuario(seguidoId);

        if (seguidor == null) {
            System.out.println("El usuario seguidor '" + seguidorId + "' no existe.");
            return false;
        }
        if (seguido == null) {
            System.out.println("El usuario seguido '" + seguidoId + "' no existe.");
            return false;
        }
        if (seguidor.equals(seguido)) {
            System.out.println("Un usuario no puede seguirse a sí mismo.");
            return false;
        }

        List<Usuario> seguidos = listaAdyacencia.get(seguidor);
        if (seguidos.contains(seguido)) {
            System.out.println("El usuario '" + seguidorId + "' ya está siguiendo a '" + seguidoId + "'.");
            return false;
        }

        seguidos.add(seguido);
        System.out.println("El usuario '" + seguidorId + "' ahora sigue a '" + seguidoId + "'.");
        return true;
    }

    // Dejar de seguir a otro usuario
    public boolean dejarDeSeguir(String seguidorId, String seguidoId) {
        Usuario seguidor = obtenerUsuario(seguidorId);
        Usuario seguido = obtenerUsuario(seguidoId);

        if (seguidor == null) {
            System.out.println("El usuario seguidor '" + seguidorId + "' no existe.");
            return false;
        }
        if (seguido == null) {
            System.out.println("El usuario seguido '" + seguidoId + "' no existe.");
            return false;
        }

        List<Usuario> seguidos = listaAdyacencia.get(seguidor);
        if (!seguidos.contains(seguido)) {
            System.out.println("El usuario '" + seguidorId + "' no está siguiendo a '" + seguidoId + "'.");
            return false;
        }

        seguidos.remove(seguido);
        System.out.println("El usuario '" + seguidorId + "' ha dejado de seguir a '" + seguidoId + "'.");
        return true;
    }

    // Obtener la lista de usuarios que un usuario dado sigue
    public List<String> obtenerSeguidos(String id) {
        Usuario usuario = obtenerUsuario(id);
        if (usuario == null) {
            System.out.println("El usuario '" + id + "' no existe.");
            return Collections.emptyList();
        }
        List<Usuario> seguidos = listaAdyacencia.get(usuario);
        List<String> result = new ArrayList<>();
        for (Usuario u : seguidos) {
            result.add(u.getId());
        }
        return result;
    }

    // Obtener la lista de usuarios que siguen a un usuario dado
    public List<String> obtenerSeguidores(String id) {
        Usuario usuario = obtenerUsuario(id);
        if (usuario == null) {
            System.out.println("El usuario '" + id + "' no existe.");
            return Collections.emptyList();
        }
        List<String> seguidores = new ArrayList<>();
        for (Map.Entry<Usuario, List<Usuario>> entry : listaAdyacencia.entrySet()) {
            Usuario seguidor = entry.getKey();
            List<Usuario> seguidos = entry.getValue();
            if (seguidos.contains(usuario)) {
                seguidores.add(seguidor.getId());
            }
        }
        return seguidores;
    }

    // Método auxiliar para obtener un Usuario por su ID
    private Usuario obtenerUsuario(String id) {
        for (Usuario usuario : listaAdyacencia.keySet()) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
}
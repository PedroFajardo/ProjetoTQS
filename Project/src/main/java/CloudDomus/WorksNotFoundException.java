package CloudDomus;

class WorksNotFoundException extends RuntimeException {

    WorksNotFoundException(Long id) {
        super("Could not find work with id:  " + id);
    }

}
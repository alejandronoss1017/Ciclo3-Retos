BEGIN
    DELETE FROM AUDITORIO
    WHERE ID = :id;
    :status_code :=204;
END;
BEGIN
    INSERT INTO AUDITORIO (ID, OWNER, CAPACITY, CATEGORY_ID, NAME)
    VALUES (:id, :owner, :capacity, :category_id, :name);
    :status_code := 201;
END;
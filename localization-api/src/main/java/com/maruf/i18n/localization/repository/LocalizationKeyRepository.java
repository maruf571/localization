package com.maruf.i18n.localization.repository;

import com.maruf.i18n.localization.entity.LocalizationKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocalizationKeyRepository extends CrudRepository<LocalizationKey, Long> {


    @Query("SELECT l FROM LocalizationKey l " +
            " LEFT JOIN FETCH l.localizationValues " +
            " WHERE l.project.name=?1 AND l.langKey=?2")
    LocalizationKey findByProjectNameAndKey(String projectName, String key);

    @Query("SELECT l FROM LocalizationKey l " +
            " LEFT JOIN FETCH l.localizationValues lv " +
            " WHERE l.project.id=?1  AND l.id=?2")
    LocalizationKey findByProjectNameAndKey(Long projectId, Long localizationId);

    @Query("SELECT l FROM LocalizationKey l " +
            " LEFT JOIN FETCH l.localizationValues " +
            " WHERE l.project.id=?1 AND l.langKey=?2")
    Optional<LocalizationKey> findByProjectIdAndKey(Long projectId, String key);


    @Query(value = "SELECT l.langKey from LOCALIZATION_KEY l" +
            " LEFT JOIN PROJECT p  ON p.id=l.project_id " +
            " WHERE p.name=?1 ",
            nativeQuery = true)
    List<String> getAllKeysByProject(String projectName);



}

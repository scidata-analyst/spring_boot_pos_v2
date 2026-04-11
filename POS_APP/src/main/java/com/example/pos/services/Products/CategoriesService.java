package com.example.pos.services.Products;

import com.example.pos.dtos.request.Products.CategoriesRequest;
import com.example.pos.dtos.response.Products.CategoriesResponse;

import java.util.List;

/**
 * =====================================================
 * Service Contract: Categories
 * =====================================================
 *
 * Repository-style semantic methods:
 * - all()     -> get all records
 * - index()   -> UI listing (paginated later if needed)
 * - view()    -> single record view
 * - create()  -> create new record
 * - update()  -> update existing record
 * - delete()  -> delete record
 *
 * This interface is used by Service Implementation layer.
 */
public interface CategoriesService {

    List<CategoriesResponse> all();

    List<CategoriesResponse> index();

    CategoriesResponse view(Long id);

    CategoriesResponse create(CategoriesRequest request);

    CategoriesResponse update(Long id, CategoriesRequest request);

    void delete(Long id);
}

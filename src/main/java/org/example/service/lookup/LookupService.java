package org.example.service.lookup;

import java.util.List;

public interface LookupService {
    /** count elements via bpmn process */
    int count(List<String> regionNumbers);
}

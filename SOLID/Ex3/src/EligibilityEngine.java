import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store) {
        this.store = store;
        this.rules = initializeRules();
    }

    private List<EligibilityRule> initializeRules() {
        List<EligibilityRule> ruleList = new ArrayList<>();
        ruleList.add(new DisciplinaryRule());
        ruleList.add(new CgrRule());
        ruleList.add(new AttendanceRule());
        ruleList.add(new CreditsRule());
        return ruleList;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> failures = new ArrayList<>();

        for (EligibilityRule rule : rules) {
            if (!rule.isSatisfied(s)) {
                failures.add(rule.getFailureReason());
            }
        }

        String status = failures.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";
        return new EligibilityEngineResult(status, failures);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;

    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}

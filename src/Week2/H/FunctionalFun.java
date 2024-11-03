package Week2.H;

import java.util.*;


public class FunctionalFun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            try {
                String[] domainInput = scanner.nextLine().split(" ");
                Set<String> domain = new HashSet<>(Arrays.asList(Arrays.copyOfRange(domainInput, 1, domainInput.length)));

                String[] codomainInput = scanner.nextLine().split(" ");
                Set<String> codomain = new HashSet<>(Arrays.asList(Arrays.copyOfRange(codomainInput, 1, codomainInput.length)));

                System.out.println(testCase(domain, codomain, scanner));
            } catch (NoSuchElementException e) {
                break;
            }
        }

        scanner.close();
    }

    public static String testCase(Set<String> domain, Set<String> codomain, Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> functionMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] mapping = scanner.nextLine().split(" -> ");
            String domElement = mapping[0];
            String codElement = mapping[1];

            if (functionMap.containsKey(domElement) && !functionMap.get(domElement).equals(codElement)) {
                return "not a function";
            }
            functionMap.put(domElement, codElement);
        }

        Set<String> functionDomain = functionMap.keySet();
        Set<String> functionCodomain = new HashSet<>(functionMap.values());

        if (!domain.containsAll(functionDomain) || !codomain.containsAll(functionCodomain)) {
            return "not a function";
        }

        boolean injective = functionMap.size() == functionCodomain.size();
        boolean surjective = functionCodomain.containsAll(codomain);

        if (surjective) {
            if (injective) {
                return "bijective";
            } else {
                return "surjective";
            }
        } else {
            if (injective) {
                return "injective";
            } else {
                return "neither injective nor surjective";
            }
        }
    }

}

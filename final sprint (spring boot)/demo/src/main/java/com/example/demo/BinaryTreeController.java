package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class BinaryTreeController {

    @Autowired
    private BinaryTreeService binaryTreeService;

    @GetMapping("/enter-numbers")
    public String showEnterNumbersPage() {
        return "enter_numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam("numbers") String numbers) {
        binaryTreeService.processNumbers(numbers);
        return "redirect:/enter-numbers";
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<BinaryTree> trees = binaryTreeService.getPreviousTrees();
        model.addAttribute("trees", trees);
        return "previous_trees";
    }
}

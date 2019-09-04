**Initial setup**

1. Install IntelliJ IDE
2. Install Java 8
3. Import as maven project
4. In IntelliJ, Navigate to Preferences -> Plugins  and add the below plugins
	Gherkin
	Cucumber for Java

   
**How to run project**  

1. Navigate to src > test > java > runner. Open the "RunTest" class and run the class.
2. Navigate to src > test > resources > features. Right click on "JSON_Placeholder.feature" and click Run feature
3. You can also open "JSON_Placeholder.feature" right click on individual test scenario and run each scenaro individually.

Note: 
1. I have fully coded the scenario "Testing JSON Placeholder for comments validation by specific user". Which will run and pass 100%.
2. I have written another 3 high level scenarios in feature file but not implemented the steps. Those scenarios will skip the steps.
3. If you still want to run those scenarios using runner file please add the tag @test in begining of the scenario you are going to run. Or follow any steps mentioned in the section "How to run project"
   


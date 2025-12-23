# AWS Cost Governance & Guardrails Framework

This repository contains a collection of **Service Control Policies (SCPs)** and a deployment guide to implement automated cost protection and regional governance in an AWS Organization.

## 📁 Repository Structure

| File | Policy Name | Description |
| :--- | :--- | :--- |
| `BudgetLockdown.json` | **BudgetLockdown** | The "Emergency Brake." Denies all resource-creation actions (EC2, SageMaker, etc.) when budget is breached. |
| `DenyExpensiveEC2.json` | **RestrictInstanceTypes** | Limits EC2 usage to the `t2` and `t3` families to prevent high-cost accidental launches. |
| `RestrictSageMaker.json` | **LimitSageMaker** | Restricts SageMaker notebook instances to specific allowed types (e.g., `ml.t3.medium`). |
| `DenyAllOutsideUsEast1.json` | **RegionLock** | Blocks all AWS actions in any region other than `us-east-1` to prevent hidden costs. |

---

## 🛠️ Step-by-Step Deployment Guide

Follow these steps to implement the "Safety Net" in a new AWS environment.

### Phase 1: Organizations Setup
1. **Enable All Features:** Ensure your AWS Organization is in "All Features" mode (Organizations > Settings).
2. **Create the OU:** Create a new Organizational Unit (OU) named `Research-Project`.
3. **Move Account:** Move the target student/research account into the `Research-Project` OU.
4. **Enable SCPs:** In the Organizations sidebar, go to **Policies** > **Service Control Policies** and click **Enable**.

### Phase 2: IAM Role Configuration
AWS Budgets needs a "Security Guard" role to apply the lockdown policy for you.
1. Create an IAM Role named `AWSBudgetsActionRole`.
2. **Trust Policy:** Set the Trust Relationship to allow `budgets.amazonaws.com`.
3. **Permissions:** Attach an inline policy with the following permissions:
   - `organizations:AttachPolicy`
   - `organizations:ListRoots`
   - `organizations:ListOrganizationalUnitsForParent`
   - `organizations:DescribeOrganizationalUnit`
   - `organizations:DescribeOrganization`
   - `organizations:ListPolicies`
   - Target: `*` (or specific OU/Policy ARNs for tighter security).

### Phase 3: Creating the Budget & Action
1. Go to **AWS Budgets** > **Create Budget**.
2. **Budget Type:** Cost Budget.
3. **Scope:** Filter by **Linked Account** and select your Research Account ID.
4. **Threshold:** Set to **100% of Actual Cost** (e.g., $20.00).
5. **Set Action:**
   - **Action Type:** Service Control Policy (SCP).
   - **Policy to apply:** Select `BudgetLockdown`.
   - **Target:** Select the `Research-Project` OU.
   - **Execution:** Choose **Automatic**.

---

## 🛡️ Governance Best Practices
* **The "Standby" Status:** In the Budgets dashboard, your budget should show **Standby (1)**. This means the guardrail is armed and ready.
* **Testing:** To test the lockdown without spending money, temporarily set a budget for **$0.01**. Once you confirm the OU is locked, change it back to your real threshold.
* **Management Account Safety:** Remember that SCPs **do not** affect the Management (Root) account. You will always be able to log in to the management account to "unlock" the project if the budget is hit.

## 🚨 Recovery Procedure
If the account is locked (you see "Access Denied" for everything):
1. Log in to the **Management Account**.
2. Go to **AWS Organizations** > **Research-Project OU**.
3. Select the **Policies** tab.
4. Find `BudgetLockdown` and click **Detach**.
5. Adjust your budget or clean up resources before detaching the policy.
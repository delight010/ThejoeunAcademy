//
//  ViewController.swift
//  0721_SwipeGesture_PageControl
//
//  Created by TJ on 2021/07/21.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var pageControl: UIPageControl!
    
    var images = ["flower_01.png", "flower_02.png", "flower_03.png", "flower_04.png", "flower_05.png", "flower_06.png"]
    var number: Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        imageView.image = UIImage(named: images[0])
        
        pageControl.numberOfPages = images.count // 동그라미 갯수 설정
        pageControl.currentPage = 0 // 처음 동그라미에 위치
        pageControl.pageIndicatorTintColor = UIColor.green // 동그라이 색깔 바꾸기
        pageControl.currentPageIndicatorTintColor = UIColor.red // 현재 동그라미 위치 색깔 바꾸기
        
        // 한손가락 Gesture 구성
        makeSingleTouch()
        
    }
    
    @IBAction func pageChange(_ sender: UIPageControl) {
        imageView.image = UIImage(named: images[pageControl.currentPage]) // 동그라미 위치에 따른 이미지 출력
    }
    
    
    // 제스처에 따른 이미지 전환
    // 1 손가락 터치
    func makeSingleTouch() {
        // UP
        let swipeUp = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGesture(_:))) // 인식
        swipeUp.direction = UISwipeGestureRecognizer.Direction.up
        self.view.addGestureRecognizer(swipeUp)
        
        // Down
        let swipeDown = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGesture(_:))) // 인식
        swipeDown.direction = UISwipeGestureRecognizer.Direction.down
        self.view.addGestureRecognizer(swipeDown)
        
        // Left
        let swipeLeft = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGesture(_:))) // 인식
        swipeLeft.direction = UISwipeGestureRecognizer.Direction.left
        self.view.addGestureRecognizer(swipeLeft)
        
        // Right
        let swipeRight = UISwipeGestureRecognizer(target: self, action: #selector(ViewController.respondsToSwipeGesture(_:))) // 인식
        swipeRight.direction = UISwipeGestureRecognizer.Direction.right
        self.view.addGestureRecognizer(swipeRight)
    }
    
    // object-c 함수 설정
    @objc func respondsToSwipeGesture(_ gesture: UIGestureRecognizer){
        if let swipeGesture = gesture as? UISwipeGestureRecognizer{ // 변환
                       
            // 제스처가 들어오면
            switch swipeGesture.direction{
            case UISwipeGestureRecognizer.Direction.up:
                pageControl.currentPage += 1
                imageView.image = UIImage(named: images[pageControl.currentPage])
            case UISwipeGestureRecognizer.Direction.down:
                pageControl.currentPage -= 1
                imageView.image = UIImage(named: images[pageControl.currentPage])
            case UISwipeGestureRecognizer.Direction.left:
                pageControl.currentPage -= 1
                imageView.image = UIImage(named: images[pageControl.currentPage])
            case UISwipeGestureRecognizer.Direction.right:
                pageControl.currentPage += 1
                imageView.image = UIImage(named: images[pageControl.currentPage]) 
            default:
                break
            }
        }
    }
    
    

} // ViewController

